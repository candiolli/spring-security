package com.example.demospringsecuritydb.config;

import com.example.demospringsecuritydb.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableConfigurationProperties
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                    .antMatchers("/resources/**", "/h2-console/**").permitAll()
//                    .antMatchers("/", "/home").hasRole("VISUALIZAR_RELATORIO_EQUIPE")
//                    .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                    .loginPage("/login").permitAll()
//                .and()
//                .logout()
//                .permitAll();

        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/books/**").hasRole("VISUALIZAR_RELATORIO_EQUIPE")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        System.out.println("BCrypt password = " + new BCryptPasswordEncoder().encode("123"));
        builder
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());

    }

}
