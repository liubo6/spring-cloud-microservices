package com.liubo.account.web;

import com.liubo.account.model.AccountResult;
import com.liubo.account.model.UserDO;
import com.liubo.account.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hzlbo on 2017/2/16 0016.
 */
@Api(description = "用户相关接口")
@RestController
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     * http://localhost:8080/swagger-ui.html
     *
     * @param userDO
     * @return
     */

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(notes = "用户注册", value = "用户注册", httpMethod = "POST")
    public String register(@RequestBody UserDO userDO) {
        return userService.register(userDO).toString();
    }

    /**
     * 用户登录，返回成功信息，将token写入cookie
     *
     * @param userDO
     * @param response
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody UserDO userDO, HttpServletResponse response) {
        AccountResult accountResult = userService.login(userDO);
        String token = (String) accountResult.getContent();
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(60 * 60 * 24);//second
        response.addCookie(cookie);
        accountResult.setContent("");
        return accountResult.toString();
    }

    /**
     * 检查用户是否登录
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public String checkLogin(@CookieValue(value = "token", defaultValue = "none") String token) {
        return userService.checkLogin(token).toString();
    }


    /**
     * 根据手机号码查询用户信息
     *
     * @param phone
     * @return
     */
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public UserDO getUserInfo(@RequestParam("phone") String phone) {
        return userService.getUserByPhone(phone);
    }
}
