package com.pan.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class AlphaConfig {
    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    @Bean
    public String myName() {
        return "pan shuai";
    }
    @Bean
    public String secName() {
        return "sec pan";
    }
}
