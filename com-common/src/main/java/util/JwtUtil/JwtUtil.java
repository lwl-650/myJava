package util.JwtUtil;

import io.jsonwebtoken.*;
import pojo.User;

import java.util.Date;

public class JwtUtil {
    private static long time = 1000 * 60 * 60 * 24;
    private static String signature = "lwlAndSl";

    public static String createToken(User user) {
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
//                header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
//                payload
                .claim("name", user.getName())
                .claim("password", user.getPassword())
                .setId(String.valueOf(user.getId()))
                .setExpiration(new Date(System.currentTimeMillis() + time))
//                signature
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        return jwtToken;

    }

    public static boolean checkToken(String token){
        if (token==null){
            return false;
        }
        try{
            Jws<Claims> claimsJwt =Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}

