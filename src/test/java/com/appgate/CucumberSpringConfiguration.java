package com.appgate;

import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.java.Before;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = TestConfig.class)
@CucumberContextConfiguration
@ContextConfiguration(classes = {TestConfig.class, StartApplication.class}, loader = SpringBootContextLoader.class)
public class CucumberSpringConfiguration {
    @Before
    public void setup(){
        System.out.println("Context started!");
    }
}

