package com.example.baseb.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloTest {

    @Value("${a.b.c}") String d;

    @Test
    void valueTest() {
        System.out.println("d = " + d);
    }
}
