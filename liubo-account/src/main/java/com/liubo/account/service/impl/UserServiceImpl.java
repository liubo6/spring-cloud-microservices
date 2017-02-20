package com.liubo.account.service.impl;

import com.liubo.account.JJWTUtil;
import com.liubo.account.dao.UserDao;
import com.liubo.account.model.AccountResult;
import com.liubo.account.model.UserDO;
import com.liubo.account.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by hzlbo on 2017/2/16 0016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    /**
     * 注册
     *
     * @param userDO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public AccountResult register(UserDO userDO) {
        AccountResult x = validateAccount(userDO);
        if (!x.isResult()) return x;
        //1 查询是否已经注册
        boolean exist = userDao.existPhone(userDO.getPhone()) > 0;
        if (exist) {
            return AccountResult.falseResult("该电话号码已经注册，请直接登录");
        }

        //2 BCrypt密码加密
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        String pwd = bCryptPasswordEncoder.encode(userDO.getPassword());
        userDO.setPassword(pwd);
        userDO.setId(UUID.randomUUID().toString().replace("-", ""));
        boolean result = userDao.insertUser(userDO);
        if (result) {
            return AccountResult.trueResult("注册成功");
        }
        return AccountResult.trueResult("注册失败");
    }

    private AccountResult validateAccount(UserDO userDO) {
        if (null == userDO) {
            return AccountResult.falseResult("用户信息不能为空");
        }
        if (StringUtils.isEmpty(userDO.getPhone())) {
            return AccountResult.falseResult("用户电话号码不能为空");
        }
        if (StringUtils.isEmpty(userDO.getPassword())) {
            return AccountResult.falseResult("用户密码不能为空");
        }
        return new AccountResult(true);
    }

    /**
     * 登录
     *
     * @param userDO
     * @return
     */
    @Override
    public AccountResult login(UserDO userDO) {
        AccountResult x = validateAccount(userDO);
        if (!x.isResult()) return x;
        //1 密码校验
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        String hashPwd = userDao.getPwdByPhone(userDO.getPhone());
        boolean result = bCryptPasswordEncoder.matches(userDO.getPassword(), hashPwd);
        if (!result) {
            return AccountResult.falseResult("用户名或者密码错误");
        }
        //2 JWT生成token
        String token = "";
        try {
            token = new JJWTUtil().createJWT(userDO.getUserId(), userDO.getPhone(), "", 1000 * 60 * 30);
        } catch (Exception e) {
            token = "none";
        }

        return AccountResult.trueResult("登录成功", token);
    }

    /**
     * 检验是否登录
     *
     * @param token
     * @return
     */
    @Override
    public AccountResult checkLogin(String token) {
        try {
            if (StringUtils.isEmpty(token) || "none".equals(token)) {
                return AccountResult.falseResult("用户未登录");
            }
            Claims claims = new JJWTUtil().parseJWT(token);
            String phone = (String) claims.get("phone");
            return AccountResult.trueResult("用户 " + phone + "已经登录");
        } catch (ExpiredJwtException e) {
            AccountResult.falseResult("请重新登录");
        } catch (Exception e) {
            return AccountResult.falseResult("用户未登录");
        }

        return AccountResult.falseResult("用户未登录");
    }

    /**
     * 查询用户信息
     *
     * @param phone
     * @return
     */
    @Cacheable(value = "userCache", key = "'USER:INFO:'+#phone")
    @Override
    public UserDO getUserByPhone(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return new UserDO();
        }
        return userDao.getUserByPhone(phone);
    }
}
