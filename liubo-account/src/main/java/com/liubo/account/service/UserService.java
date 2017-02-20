package com.liubo.account.service;

import com.liubo.account.model.AccountResult;
import com.liubo.account.model.UserDO;

/**
 * Created by hzlbo on 2017/2/16 0016.
 */
public interface UserService {

    /**
     * 注册
     *
     * @param userDO
     * @return
     */
    AccountResult register(UserDO userDO);

    /**
     * 登录
     *
     * @param userDO
     * @return
     */
    AccountResult login(UserDO userDO);

    /**
     * 检验是否登录
     *
     * @param token
     * @return
     */
    AccountResult checkLogin(String token);

    /**
     * 查询用户信息
     *
     * @param phone
     * @return
     */
    UserDO getUserByPhone(String phone);
}
