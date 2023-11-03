package com.adrian.memberapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .headers().frameOptions().sameOrigin()
                .and()
                .authorizeRequests(configurer ->
                        configurer
                                .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).hasAnyRole()
                                .requestMatchers(new AntPathRequestMatcher("/mypages/members/**")).hasRole("USER")
                                .requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
                );
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrf -> csrf.disable());
        return httpSecurity.build();
    }
}
