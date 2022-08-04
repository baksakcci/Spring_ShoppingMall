package com.studyProjectA.ShoppingMall.Configuration;

import com.studyProjectA.ShoppingMall.Repository.UserRepository;
import com.studyProjectA.ShoppingMall.jwt.JwtAuthenticationFilter;
import com.studyProjectA.ShoppingMall.jwt.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CorsConfig corsConfig;

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.addFilter(corsConfig.corsFilter())
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), userRepository))
                .authorizeRequests()
                .antMatchers("/user")
                .access("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN')")
                .antMatchers("/shop")
                .access("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN')")
                .antMatchers("/manager")
                .access("hasRole('MANAGER') or hasRole('ADMIN')")
                .antMatchers("/admin")
                .access("hasRole('ADMIN')")
                .anyRequest().permitAll();
    }
}
