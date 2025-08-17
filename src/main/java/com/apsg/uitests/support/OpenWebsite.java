package com.apsg.uitests.support;

import com.apsg.uitests.util.JsonValueFactory;
import com.apsg.uitests.util.WebDriverFactory;

public class OpenWebsite {

    public void openWebsite(String url) {
        url = new JsonValueFactory().getText(url);
        if (url.startsWith("http://") || url.startsWith("https://")) {
            WebDriverFactory.getDriver().navigate().to(url);
        } else {
            throw new IllegalArgumentException("Invalid URL: " + url + ". URL must start with http:// or https://");
        }
    }

}
