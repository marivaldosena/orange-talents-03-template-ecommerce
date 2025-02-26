package com.github.marivaldosena.mercadolivre.auth;

import com.github.marivaldosena.mercadolivre.products.ProductController;
import com.github.marivaldosena.mercadolivre.purchases.gateway.PaymentController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {
    private UserManager userManager;

    public AppSecurityConfiguration(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userManager).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, RegistrationController.RESOURCE_URL).permitAll()
                .antMatchers(HttpMethod.POST, LoginController.RESOURCE_URL).permitAll()
                .antMatchers(HttpMethod.GET, ProductController.RESOURCE_URL + "/**").permitAll()
                .antMatchers(PaymentController.RESOURCE_URL).permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new TokenAuthenticationFilter(userManager), UsernamePasswordAuthenticationFilter.class);
    }
}
