package com.julianduru.fileuploader;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(
    basePackages = {
        "com.julianduru.fileuploader.entities",
    }
)
@ComponentScan(
    basePackages = {
        "com.julianduru.fileuploader",
    }
)
public class JpaFileUploaderAutoConfiguration {


}
