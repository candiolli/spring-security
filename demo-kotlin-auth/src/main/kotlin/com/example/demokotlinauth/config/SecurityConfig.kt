package com.example.demokotlinauth.config

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder

@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/books").hasRole("USER")
                .antMatchers("/books2").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("user").password("test123").roles("USER")
                .and()
                .withUser("admin").password("test123").roles("USER", "ADMIN");
    }
}

