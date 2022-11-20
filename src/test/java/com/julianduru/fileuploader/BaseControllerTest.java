package com.julianduru.fileuploader;


import com.julianduru.fileuploader.config.TestConfig;
import com.julianduru.fileuploader.config.TestDataSourceConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * created by julian
 */
@Slf4j
@Testcontainers
@ExtendWith({SpringExtension.class})
@SpringBootTest(
    classes = {
        TestConfig.class,
//        TestDataSourceConfig.class,
        JpaFileUploaderAutoConfiguration.class,
    }
)
@AutoConfigureMockMvc
public abstract class BaseControllerTest {


    @Autowired
    protected MockMvc mockMvc;


}

