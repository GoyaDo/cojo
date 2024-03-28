package com.ysmjjsy.goya.cojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.ysmjjsy.goya.cojo.**.domain")
@EnableJpaRepositories(basePackages = "com.ysmjjsy.goya.cojo.**.repository")
public class CojoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CojoApplication.class, args);
    }

}
