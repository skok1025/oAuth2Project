package com.cafe24.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers(HttpMethod.GET, "/api/data**").access("#oauth2.hasScope('read_data')")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/api/data**").access("#oauth2.hasScope('write_data')")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.PUT, "/api/data**").access("#oauth2.hasScope('write_data')")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/data**").access("#oauth2.hasScope('write_data')")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}