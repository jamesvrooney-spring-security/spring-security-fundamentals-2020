package com.jamesvrooney.config;

import com.jamesvrooney.security.filters.CustomAuthenticationFilter;
import com.jamesvrooney.security.providers.CustomAuthenticationProvider;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomAuthenticationFilter customAuthenticationFilter;
//    private final CustomAuthenticationProvider customAuthenticationProvider;
//    @Bean
//    public AuthenticationManager authenticationManager() {
//        return new ProviderManager();
//    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .addFilterAt(customAuthenticationFilter, BasicAuthenticationFilter.class)
//                .authenticationManager(new ProviderManager())
                .authorizeHttpRequests(auth -> {
                    auth.anyRequest().authenticated();
                })
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }
}