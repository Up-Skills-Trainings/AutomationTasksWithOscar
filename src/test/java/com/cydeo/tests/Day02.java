package com.cydeo.tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Day02 {
    WebDriver driver;
    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Selenium 4
        driver.get("https://automationbookstore.dev/");
    }
    @AfterEach
    public void close(){
        driver.quit();
    }

    @Test
    public void screenShotTest(){

        // Let's take a screenshot of entire page
        File wholeScrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(wholeScrFile, new File("src/test/java/com/cydeo/screenshots/wholePage.png")); // project root
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // taking screenshots of a certain element
        WebElement seleniumBook = driver.findElement(By.id("pid6"));
        File seleniumScrFile = seleniumBook.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(seleniumScrFile,new File("src/test/java/com/cydeo/screenshots/seleniumBook.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void addingCookies() throws InterruptedException {

        driver.manage().addCookie(new Cookie("cydeoBucket","testing123"));

        Thread.sleep(15000);

        driver.manage().deleteAllCookies();

    }


}
