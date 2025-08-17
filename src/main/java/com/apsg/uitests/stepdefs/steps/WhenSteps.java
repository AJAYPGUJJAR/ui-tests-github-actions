package com.apsg.uitests.stepdefs.steps;

import io.cucumber.java.en.When;

public class WhenSteps {

    @When("I set {string} to the inputfield {string}")
    public void iSetToTheInputfield(String text, String selector) {
//        driver.findElement(By.xpath(selector)).sendKeys(text);
    }

    @When("I press {string}")
    public void iPress(String key) {
//        new Actions(driver).sendKeys(Keys.ENTER).perform();
    }

}
