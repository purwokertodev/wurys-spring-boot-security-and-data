package com.wury.boot.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by WURI on 15/03/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.wury.boot.*")
@PropertySource({"classpath:application.properties"})
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/stylesheets/**").addResourceLocations("/stylesheets/");
        registry.addResourceHandler("/javascripts/**").addResourceLocations("/javascripts/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/signin").setViewName("signin");
        registry.addViewController("/error/error404").setViewName("error404");
        registry.addViewController("/error/error505").setViewName("error505");
        registry.addViewController("/error").setViewName("error");
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/error404");
                ErrorPage error505Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/error505");

                container.addErrorPages(error404Page, error505Page);
            }
        };
    }

    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
