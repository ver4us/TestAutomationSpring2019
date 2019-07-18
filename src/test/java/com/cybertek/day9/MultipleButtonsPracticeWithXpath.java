package com.cybertek.day9;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MultipleButtonsPracticeWithXpath {

    WebDriver driver;
    //only buttons from 1-5
    String buttons = "//button[starts-with(text(),'Button')]";
          // buttons="//button[contains(text(),'Button')]";
          // buttons="//button[starts-with(@onclick,'button')]";
    String button3Locator = "//button[starts-with(@id,'button_')]";
    String resultLocator = "//p[@id='result']";
    String button4Locator = "//button[contains(text(),'Button 4')]";
    String button5Locator = "//button[5]";
    String button6locator = "//*[@id='disappearing_button']";
    String allButtonsLocator = "//button[starts-with(@onclick,'button')]";


    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }

    @Test
    public void verifyButton3(){
        String expectedMessage = "Clicked on button three!";
        driver.findElement(By.xpath(button3Locator)).click();
        SeleniumUtils.waitPlease(2);
        String actualMessage = driver.findElement(By.xpath(resultLocator)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }


    @Test
    public void verifyButton4(){
        String expectedMessage = "Clicked on button four!";
        driver.findElement(By.xpath(button4Locator)).click();
        SeleniumUtils.waitPlease(2);
        String actualMessage = driver.findElement(By.xpath(resultLocator)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void verifyButton6(){
        String expectedMessage = "Now it's gone!";
        driver.findElement(By.xpath(button6locator)).click();
        SeleniumUtils.waitPlease(2);
        String actualMessage = driver.findElement(By.xpath(resultLocator)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
       // Assert.assertTrue(driver.findElement(By.xpath(button6locator)).isDisplayed());
       // you cant use assertFalse because there is no such button!
       // Assert.assertFalse(driver.findElement(By.xpath(button6locator)).isDisplayed());
       // Assert.assertTrue(driver.findElements(By.xpath(button6locator)).size()==0);
        Assert.assertTrue(driver.findElement(By.xpath(button5Locator)).isDisplayed());

        //System.out.println(driver.findElements(By.xpath(allButtonsLocator)).size());
    }

    @Test
    public void clickOnEveryButton(){
        List<WebElement> buttons = driver.findElements(By.xpath(allButtonsLocator));
        for (WebElement button : buttons){
            button.click();
            SeleniumUtils.waitPlease(1);
        }
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
