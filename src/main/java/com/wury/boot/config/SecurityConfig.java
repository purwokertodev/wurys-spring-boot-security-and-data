package com.wury.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.EnumSet;

/**
 * Created by WURI on 15/03/2016.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // Security configuration for H2 console access
        // !!!! You MUST NOT use this configuration for PRODUCTION site !!!!
        httpSecurity.authorizeRequests().antMatchers("/console/**").permitAll();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();

        httpSecurity.authorizeRequests().antMatchers("/stylesheets/**", "/javascripts/**", "/images/**", "/resources/**").permitAll();

        httpSecurity.authorizeRequests()
                .antMatchers("/", "/home/**", "/rest/public/**", "/signin/**", "/registration/**", "/error/**", "/author_profile/**", "/post_detail/**", "/create_comment").permitAll()
				.antMatchers("/author/**").hasAuthority("AUTHOR")
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/signin")
                .loginProcessingUrl("/login-process")
                .failureUrl("/signin?error")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/author/dashboard", true)
                .and()
                .logout()
                .logoutSuccessUrl("/signin?logout");

        httpSecurity.exceptionHandling().accessDeniedPage("/author/dashboard");
        httpSecurity.sessionManagement().invalidSessionUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public FilterRegistrationBean getSpringSecurityFilterChainBindedToError(
            @Qualifier("springSecurityFilterChain") Filter springSecurityFilterChain) {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(springSecurityFilterChain);
        registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        return registration;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}
