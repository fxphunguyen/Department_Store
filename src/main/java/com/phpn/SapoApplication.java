package com.phpn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:versions.properties")
@EntityScan("vn.fx.qh.sapo.entities")
public class SapoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SapoApplication.class, args);
    }

}