package com.apsg.uitests.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileReader;

public class JsonValueFactory {

    public WebElement getWebElement(String selector) {
        String[] arr = selector.split("\\.");
        String jsonFilePath = new File("src/test/resources/project01/testdata/" + arr[0] + ".json").getAbsolutePath();
        try {
            FileReader fileReader = new FileReader(jsonFilePath);
            Object o = new JSONParser().parse(fileReader);
            selector = ((JSONObject) ((JSONObject) o).get(arr[1])).get(arr[2]).toString();
            return WebDriverFactory.getDriver().findElement(selector.charAt(0) == '#' ? By.cssSelector(selector) : By.xpath(selector));
        } catch (Exception ignored) {
        }
        return WebDriverFactory.getDriver().findElement(selector.charAt(0) == '#' ? By.cssSelector(selector) : By.xpath(selector));
    }

    public String getText(String selector) {
        String[] arr = selector.split("\\.");
        String jsonFilePath = new File("").getAbsolutePath();
        try {
            FileReader fileReader = new FileReader(jsonFilePath);
            Object o = new JSONParser().parse(fileReader);
            return ((JSONObject) ((JSONObject) o).get(arr[1])).get(arr[2]).toString();
        } catch (Exception ignored) {
        }
        return selector;
    }

}
