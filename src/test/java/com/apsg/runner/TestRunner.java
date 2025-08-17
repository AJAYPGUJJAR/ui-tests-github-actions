package com.apsg.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features/Sample.feature",
        glue = "com.apsg.uitests.stepdefs",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
