package com.NewPractice.service.Impl;

import com.NewPractice.entity.PropertyUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {

    @Value("${jwt.algorithms.key}")
    private String algorithmKey;


    @Value("${jwt.issuers}")
    private String issuer;

    @Value("${jwt.expiryDuration}")
    private int expiryTime;

    private Algorithm algorithm;


    @PostConstruct
    public void postContruct()
    {
//        System.out.println(algorithmKey);
//        System.out.println(issuer);
//        System.out.println(expiryTime);

      algorithm = Algorithm.HMAC256(algorithmKey);
    }

    public String generatedToken(PropertyUser user)
    {
        return JWT.create()
                .withClaim("user",user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+expiryTime))
                .withIssuer(issuer)
                .sign(algorithm);
    }

}


// This is Part TwO Date:-28-03-2024