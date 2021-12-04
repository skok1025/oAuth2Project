package com.cafe24.oauth2.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.AllArgsConstructor;

@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off
		http
                .csrf().disable()
                .authorizeRequests().anyRequest()
                .authenticated()
                .and()
                .formLogin().and()
                .httpBasic();
        //@formatter:on
    }
}