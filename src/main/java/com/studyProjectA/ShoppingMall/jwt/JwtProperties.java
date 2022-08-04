package com.studyProjectA.ShoppingMall.jwt;

public interface JwtProperties {
    String SECRET = "같이하는 프로젝트 : 쇼핑몰";
    int EXPIRATION_TIME = 60000*30;
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
