package com.julianduru.fileuploader;

import com.julianduru.fileuploader.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
    classes = {
        TestConfig.class,
        JpaFileUploaderAutoConfiguration.class,
    }
)
class FileUploaderApplicationTests {

    @Test
    void contextLoads() {
    }

}
