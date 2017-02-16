package com.liubo.account;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.junit.Test;

/**
 * Created by hzlbo on 2017/2/16 0016.
 */
public class JJWTUtilTest {

    @Test
    public void testGeneralKey() throws Exception {

        String token = new JJWTUtil().createJWT("10086", "18267190230", "liubo",  1000 * 60 * 30);
        System.out.println(token);
    }

    @Test
    public void testParse() throws Exception {

        Claims claims = null;
        try {
            claims = new JJWTUtil().parseJWT("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJsaXVibyIsInVzZXJJZCI6IjEwMDg2IiwicGhvbmUiOiIxODI2NzE5MDIzMCIsIm5hbWUiOiJsaXVibyIsImp0aSI6ImExMjUzNjA2LWRiMWYtNDk0NC04OWRhLTQ1N2JjNTUzZmJjMyIsImlhdCI6MTQ4NzIxNjQ4Miwic3ViIjoiMTAwODYiLCJleHAiOjE0ODcyMTgyODJ9.IfC040EKcA4Bapud-Mt2B987x1Cb4jMTABZdAl9xFo0");
            System.out.println(claims.getSubject() + "|" + claims.getIssuer() + "|" + claims.get("phone"));
        } catch (ExpiredJwtException e) {
            System.out.println("token已经过期，重新登录");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
