package com.cydeo.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Day01 {
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
    public void getRectTest(){
        // to use getRect() method for X-Y coordinates or other shape options
        WebElement javaForTestersElement = driver.findElement(By.id("pid5"));

        System.out.println("x - coordinate - JAVA = " + javaForTestersElement.getRect().getX());
        System.out.println("y - coordinate - JAVA = " + javaForTestersElement.getRect().getY());

        WebElement seleniumAdvancedElement = driver.findElement(By.id("pid6"));

        System.out.println("seleniumAdvancedElement.getRect().getX() = " + seleniumAdvancedElement.getRect().getX());
        System.out.println("seleniumAdvancedElement.getRect().getY() = " + seleniumAdvancedElement.getRect().getY());

    }

    @Test
    public void testJavaBookLocation(){

        WebElement seleniumAdvancedElement = driver.findElement(By.id("pid6"));


        // to test Java book is located under testAutomation and left of Selenium
        /*
        Locate the element that you want to use for relative approach than give more specific information with respect to other elements
        Relative can be used for elements hard to locate with any attribute
        Relative can be  used to verify the visual aspect of the element in terms location
         */

        String actualId = driver.findElement(RelativeLocator.with(By.tagName("li"))
                        .toLeftOf(seleniumAdvancedElement)  // to provide element
                        .below(By.id("pid1")))   // provide locator
                .getAttribute("id");
        String expectedId = "pid5";

        Assertions.assertEquals(expectedId,actualId);
    }




}
