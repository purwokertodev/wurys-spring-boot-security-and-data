package com.wury.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by WURI on 15/03/2016.
 */
@SpringBootApplication
public class MyBootApplication extends SpringBootServletInitializer {

    public static void main(String [] args){
        SpringApplication.run(MyBootApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MyBootApplication.class);
    }

}
