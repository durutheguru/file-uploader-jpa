package com.julianduru.fileuploader.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * created by julian on 20/11/2022
 */
@TestConfiguration
@EnableJpaRepositories(
    basePackages = "com.julianduru.fileuploader.jpa"
)
@EnableAutoConfiguration
public class TestConfig {



}
