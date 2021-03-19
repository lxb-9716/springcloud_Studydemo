package com.it.security.swaggerUI.config;

import org.springframework.context.annotation.Configuration;

@Configuration
/*@EnableWebSecurity*/
/*Security权限的配置，哪些资源可以直接访问*/
public class SpringSecurityConfig /*extends WebSecurityConfigurerAdapter*/ {
/*    *//* 静态资源的配置*//*
    @Override
    public void configure(WebSecurity web) throws Exception {
        *//*swagger2所需要用到的资源，可以直接访问*//*
        web.ignoring().antMatchers("/v2/api-docs",
                "/swagger-resources/configuration/ui",
                "/swagger-resources",
                "/swagger-resources/configuration",
                "/swagger-ui.html");
    }

    *//*url配置*//*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll().
                antMatchers("/swagger-ui.html").permitAll().
                anyRequest().authenticated().and().logout().permitAll().and().formLogin().permitAll();
    }*/
}
