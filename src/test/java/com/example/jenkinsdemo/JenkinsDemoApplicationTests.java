package com.example.jenkinsdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JenkinsDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testHelloEndpoint() {
        JenkinsDemoApplication app = new JenkinsDemoApplication();
        assert app.hello().equals("Jenkins ile Spring Boot uygulaması!");
    }
} 