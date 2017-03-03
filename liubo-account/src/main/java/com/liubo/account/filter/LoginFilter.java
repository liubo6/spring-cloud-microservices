package com.liubo.account.filter;

import com.liubo.account.JJWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.data.redis.RedisConnectionFailureException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by hzlbo on 2017/2/16 0016.
 */
@WebFilter
public class LoginFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        System.out.println("初始化登录 filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rsp = (HttpServletResponse) servletResponse;
        String path = req.getRequestURI();
        // 登陆页面无需过滤
        if (path.indexOf("/login") > -1) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if (path.indexOf("/register") > -1) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        Cookie autoCookie = null;
        Cookie cookies[] = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    autoCookie = cookie;
                    try {
                        Claims claims = new JJWTUtil().parseJWT(autoCookie.getValue());
                        filterChain.doFilter(servletRequest, servletResponse);
                    } catch (RedisConnectionFailureException e) {

                    } catch (Exception e) {
                        OutputStream out = rsp.getOutputStream();
                        out.write("请登录".getBytes());
                        e.printStackTrace();
                        rsp.setStatus(401);
                        return;
                    }
                }
            }
            if (null == autoCookie) {
                filterChain.doFilter(servletRequest, servletResponse);
                rsp.setStatus(401);
                return;
            }

        }

    }

    @Override
    public void destroy() {
        System.out.println("销毁登录 filter");
    }
}
