package com.spin.game.config;

import com.spin.game.service.JpaUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final JpaUserDetailsService jpaUserDetailsService;
    public SecurityConfiguration(JpaUserDetailsService jpaUserDetailsService){
        this.jpaUserDetailsService = jpaUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeHttpRequests((requests) -> {
                        requests.requestMatchers("/api/registration/**").permitAll();
                        requests.requestMatchers("/home").permitAll();
                        requests.requestMatchers("/confirm").permitAll();
                        requests.requestMatchers("/test/**").permitAll();
                        requests.requestMatchers("/api/ticket/**").permitAll();
                        requests.anyRequest().authenticated();
                }
                )
                .userDetailsService(jpaUserDetailsService)
                .httpBasic(Customizer.withDefaults())
                .formLogin(formlogin -> formlogin.loginPage("/login"))
                .build();
    }

//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
}
