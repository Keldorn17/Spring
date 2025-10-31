package com.keldorn.demosecurity.security;

import com.keldorn.demosecurity.security.enums.Roles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AuthoritiesSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity, CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) throws Exception {
        httpSecurity.authorizeHttpRequests(authorize ->
                        authorize.requestMatchers("/css/**").permitAll()
                                .requestMatchers("/").hasRole(Roles.EMPLOYEE.toString())
                                .requestMatchers("/leaders").hasRole(Roles.MANAGER.toString())
                                .requestMatchers("/systems").hasRole(Roles.ADMIN.toString())
                                .requestMatchers("/register").permitAll()
                                .anyRequest().authenticated())
                .formLogin(form ->
                        form.loginPage("/login")
                                .loginProcessingUrl("/authenticate")
                                .successHandler(customAuthenticationSuccessHandler)
                                .permitAll())
                .logout(LogoutConfigurer::permitAll)
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied"));

        return httpSecurity.build();
    }
}
