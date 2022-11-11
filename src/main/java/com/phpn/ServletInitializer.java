package com.phpn;

import org.jetbrains.annotations.NotNull;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(@NotNull SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder.sources(DepartmentStoreApplication.class);
    }

}