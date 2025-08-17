package com.apsg.uitests.stepdefs;

import com.apsg.uitests.util.WebDriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@SuppressWarnings("unused")
public class StepDefs {

    private static WebDriverFactory webDriverFactory = new WebDriverFactory();

    @BeforeAll
    public static void setUp() {
        webDriverFactory.setDriver();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        System.out.println(scenario.getUri());
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }

    @AfterAll
    public static void tearDown() {
        webDriverFactory.quitDriver();
    }

}
