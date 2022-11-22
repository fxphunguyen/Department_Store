package com.phpn;

import org.jetbrains.annotations.NotNull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DepartmentStoreApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentStoreApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(@NotNull SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder.sources(DepartmentStoreApplication.class);
    }

}