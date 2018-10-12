package com.example.demo;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
public class MyPasswordEncoder implements PasswordEncoder{
    private final static String SALT = "123456";

    @Override
    public String encode(CharSequence rawPassword) {

        return null;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return false;
    }
}
