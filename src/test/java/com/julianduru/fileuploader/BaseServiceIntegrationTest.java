package com.julianduru.fileuploader;


/**
 * created by julian
 */

import com.julianduru.fileuploader.config.TestConfig;
import com.julianduru.fileuploader.config.TestDataSourceConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest(
    classes = {
        TestConfig.class,
        JpaFileUploaderAutoConfiguration.class,
    }
)
@ExtendWith({SpringExtension.class})
public class BaseServiceIntegrationTest {





}
