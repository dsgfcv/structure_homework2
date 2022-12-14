package com.example.demo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Enumeration;

public class JwtUtil {
    /**过期时间*/
    public static final long EXPIRE = 1000 * 60 * 60 * 24;

    public static final String HEADER = "Authorization";

    public static void main(String[] args) {
        System.out.println(getJwtToken(1));
    }

    /**密钥*/
    public static final String APP_SECRET = "zjKkye4PN59B2wriTjtVCo3BOYoD1B";
    /**根据id和昵称获取token*/
    public static String getJwtToken(Integer id){
        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setIssuedAt(new Date()) // 签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("id", id)
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)// 签名算法以及密匙
                .compact();
        return JwtToken;
    }

    /**
     * 判断token是否存在与有效
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     */
    public static boolean checkToken(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        String jwtToken = request.getHeader(HEADER);
        System.out.println("token:" + jwtToken);
        return checkToken(jwtToken);
    }

    /**
     * 根据token获取id
     */
    public static String getUserIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(HEADER);
        if(StringUtils.isEmpty(jwtToken)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("id");
    }
}