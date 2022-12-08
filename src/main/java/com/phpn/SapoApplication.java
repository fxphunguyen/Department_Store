package com.phpn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:versions.properties")
public class DepartmentStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentStoreApplication.class, args);
    }

}