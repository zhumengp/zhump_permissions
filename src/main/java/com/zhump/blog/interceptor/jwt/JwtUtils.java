package com.zhump.blog.interceptor.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtils {


    public static final String SECRET = "ThisIsASecret";
    public static final String TOKEN_PREFIX = "Bearer";
    /**
     * 加密tokne
     */
    public String addToken(String id,Long expirationTime,String header_string){

        String JWT = Jwts.builder()
                .setSubject(id)
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return JWT;

    }


    /**
     * 解密
     */
    public String getToken(HttpServletRequest request,String header_string){
        String header = request.getHeader(header_string);
        if (header != null) {
            if(StringUtils.isEmpty(header)){
                return null;
            }
            try{
                String id = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(header.replace(TOKEN_PREFIX, ""))
                        .getBody()
                        .getSubject();
                return id;
            }catch(Exception ex){
                return null;
            }
        }
        return null;
    }
}
