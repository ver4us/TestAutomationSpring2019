package com.cybertek.day12;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThreadSleepAndImplicitWaitTests {

    String helloWorldMessageLocator = "#finish > h4";
    String startButtonLocator = "#start > button";
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        //can handle NoSuchElementException, withing given time frame.
        // (driver will wait up to 10 seconds)
        //no strictly 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
    }

    @Test
    public void waitTest1(){

        driver.findElement(By.cssSelector(startButtonLocator)).click();
        String expectedResult = "Hello World!";
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        String actualResult = driver.findElement(By.cssSelector(helloWorldMessageLocator)).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test
    public void waitTest2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        String expectedResult = "Hello World!";
        String actualResult = driver.findElement(By.cssSelector(helloWorldMessageLocator)).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
