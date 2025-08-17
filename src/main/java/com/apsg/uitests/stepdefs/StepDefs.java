package com.apsg.uitests.stepdefs;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

@SuppressWarnings("unused")
public class StepDefs {

    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Given("I open the url {string}")
    public void iOpenTheUrl(String url) {
        driver.navigate().to(url);
    }

    @When("I set {string} to the inputfield {string}")
    public void iSetToTheInputfield(String text, String selector) {
        driver.findElement(By.xpath(selector)).sendKeys(text);
    }

    @And("I press {string}")
    public void iPress(String key) {
        new Actions(driver).sendKeys(Keys.ENTER).perform();
    }

    @Then("I expect that the title is {string}")
    public void iExpectThatTheTitleIs(String title) {
        String actualTitle = driver.getTitle();
        if (!title.equals(actualTitle)) {
            throw new AssertionError("Expected title: " + title + ", but got: " + actualTitle);
        }
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
