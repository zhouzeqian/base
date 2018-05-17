package com.kxll.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptTest {
    public static void main(String[] args){
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("admin"));
        System.out.println(bCryptPasswordEncoder.encode("mobile"));
        System.out.println(bCryptPasswordEncoder.encode("unity"));

    }
}
