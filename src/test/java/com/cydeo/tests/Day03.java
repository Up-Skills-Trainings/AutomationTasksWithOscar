package com.cydeo.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class Day03 {
    /*
    Today's topic: How to prevent ads in WebPage automation with Selenium
    1. Find extension url for ad block plus application
    https://chromewebstore.google.com/detail/adblock-plus-free-ad-bloc/cfhdojbkjhnklbpkdaibdccddilifddb?hl=en-US
    2. Paste this URL to CRX extractor: https://crxextractor.com/#google_vignette
    3. Download CRX file then add it to your project
     */

    @Test
    public void withoutAdBlock() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        Thread.sleep(5000);
        // click on submit
        driver.findElement(By.id("submit")).click();
        // we got : org.openqa.selenium.ElementClickInterceptedException: element click intercepted
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void withAdBlock() throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath = " + projectPath);
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(projectPath + "/adblockplus.crx"));

        // FirefoxOptions options1 = new FirefoxOptions(); - same approach with different files

        WebDriver driver = new ChromeDriver(options);
        Thread.sleep(5000);
        driver.get("https://demoqa.com/text-box");
        Thread.sleep(3000);
        driver.manage().window().maximize();

        driver.findElement(By.id("submit")).click();
        driver.quit();
    }

    @Test
    public void withOutAdBlockTest2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.findElement(By.partialLinkText("Test Cases")).click();
        Thread.sleep(5000);
        driver.findElement(By.partialLinkText("Home")).click();
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void withAdBlockTest2() throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath = " + projectPath);
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(projectPath + "/adblockplus.crx"));

        WebDriver driver = new ChromeDriver(options);
        Thread.sleep(3000);
        driver.get("https://automationexercise.com/");
        driver.findElement(By.partialLinkText("Test Cases")).click();
        Thread.sleep(5000);
        driver.findElement(By.partialLinkText("Home")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
