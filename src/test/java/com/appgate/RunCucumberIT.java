package com.appgate;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue="com.appgate",
        plugin = {"pretty", "json:target/cucumberReport.json", "html:target/cucumber-reports.html","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
        )
public class RunCucumberIT {

}

