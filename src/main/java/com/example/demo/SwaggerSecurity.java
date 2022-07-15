package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SwaggerSecurity extends WebSecurityConfigurerAdapter {
    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v2/api-docs",
            "/v3/api-docs",
            "/swagger-resources/**",
            "/swagger-ui/**",
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // ... here goes your custom security configuration
        http.authorizeRequests().
                antMatchers(AUTH_WHITELIST).permitAll(). // whitelist URL permitted
                antMatchers("/**").authenticated(); // others need auth
    }

}