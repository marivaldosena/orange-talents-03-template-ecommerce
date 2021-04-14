package com.github.marivaldosena.mercadolivre.auth;

import com.github.marivaldosena.mercadolivre.categories.CategoryController;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, RegistrationController.RESOURCE_URL).permitAll()
                .antMatchers(HttpMethod.POST, CategoryController.RESOURCE_URL).permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
