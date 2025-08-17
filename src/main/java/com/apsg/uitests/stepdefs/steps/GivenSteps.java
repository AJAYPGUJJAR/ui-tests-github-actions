package com.apsg.uitests.stepdefs.steps;

import com.apsg.uitests.support.OpenWebsite;
import io.cucumber.java.en.Given;

public class GivenSteps {

    @Given("I open the url {string}")
    public void iOpenTheUrl(String url) {
        new OpenWebsite().openWebsite(url);
    }

}
