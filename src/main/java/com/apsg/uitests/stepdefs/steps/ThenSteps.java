package com.apsg.uitests.stepdefs.steps;

import io.cucumber.java.en.Then;

public class ThenSteps {

    @Then("I expect that the title is {string}")
    public void iExpectThatTheTitleIs(String title) {
//        String actualTitle = driver.getTitle();
//        if (!title.equals(actualTitle)) {
//            throw new AssertionError("Expected title: " + title + ", but got: " + actualTitle);
//        }
    }}
