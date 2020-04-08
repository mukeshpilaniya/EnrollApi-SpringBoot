package com.pilaniya.enrollapi.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    @Value("$(app.jwt.secret)")
    private  String jwtSecret;

    @Value("$(app.jwt.token.prefix)")
    private  String jwtTokenPrefix;

    @Value("$(app.jwt.header.string)")
    private String jwtHeaderString;

    @Value("$(app.jwt.expiration-in-ms)")
    private String jwtExpirationInMs;


}
