package com.spin.game.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class RandomNumber {

    @Bean
    public Random randomNum(){
        return new Random();
    }
}
