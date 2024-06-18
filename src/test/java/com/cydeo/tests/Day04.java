package com.cydeo.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Day04 {
    RemoteWebDriver driver;
    @BeforeEach
    public void setUp(){
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oscartest013");
        sauceOptions.put("accessKey", "5b0de1cc-8809-4149-9255-6e39381a27a6");
        sauceOptions.put("build", "cydeoApp001");
        sauceOptions.put("name", "Connection Test");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = null;
        try {
            url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver = new RemoteWebDriver(url, browserOptions);
    }
    @AfterEach
    public void close(){
        driver.quit();
    }
    @Test
    public void cloudTestConnection(){
        driver.get("https://practice.cydeo.com/");
    }

}
