package com.cybertek.Brite_ERP.emr;

import com.cybertek.Brite_ERP.emr.BreetAPPUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import BreetAPPUtils;
//import SeleniumUtilities1;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hw_BreetAP {
    WebDriver driver;
    String userNameLocator="//input[@id='login']";
    String passwordLocator = "//input[@id='password']";
    String LoginLocator="//button[@class='btn btn-primary']";
    String CreateButton="//button[@accesskey='c']";
    String evetName="/input[@id='o_field_input_19']";
    //String evetName="//input[@name='name']";

    String StartDate="//input[@id='o_field_input_29']";
    String endDate="//input[@id='o_field_input_30']";
    String SaveButton="//button[@accesskey='s']";
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://34.220.250.213/web/login");
        WebElement usernameField = driver.findElement(By.xpath(userNameLocator));
        //Put value into the username inputbox
        usernameField.sendKeys("eventscrmmanager60@info.com");
        // find the Web element for the password inputbox
        WebElement passwordField = driver.findElement(By.xpath(passwordLocator));
        //Put value into the password inputbox
        passwordField.sendKeys("eventscrmmanager");
        // wait for 2 seconds
        SeleniumUtilities1.waitPlease(2);
        //find the Web element for login button and click/submit it
        driver.findElement(By.xpath(LoginLocator)).submit();
        SeleniumUtilities1.waitPlease(2);
    }
    //Test case for this one is:User should be able to see the list the events on event module
    @Test
    public void eventManagerTest()throws IOException{
        BreetAPPUtils.navigateToModule(driver,"Events");
        SeleniumUtilities1.waitPlease(2);
        WebElement pageNameElement = driver.findElement(By.className("active"));
        String expectedMessage = "Events";
        String actualMessage = pageNameElement.getText();
        //  Verify Dashboard page is open
        Assert.assertEquals(expectedMessage,actualMessage);
        System.out.println(actualMessage);
        SeleniumUtilities1.waitPlease(2);
        driver.get("http://34.220.250.213/web?#view_type=kanban&model=event.event&menu_id=128&action=142");
        SeleniumUtilities1.waitPlease(2);
        //BreetAPPUtils.takeAscreenShot("Event_page");


    }


    @Test
    public void eventManagerCreatingnewEvents(){
        BreetAPPUtils.navigateToModule(driver,"Events");
        SeleniumUtilities1.waitPlease(2);
        driver.findElement(By.xpath(CreateButton)).click();
        SeleniumUtilities1.waitPlease(4);


        WebElement eventNamefieldField = driver.findElement(By.xpath(evetName));

        eventNamefieldField.sendKeys("admin");//here I am trying to send event name
//        Actions performAct = new Actions(driver);
//        performAct.sendKeys(eventNamefieldField, "admin").build().perform();
//        //Put value into the password inputbox

        // wait for 2 seconds

        SeleniumUtilities1.waitPlease(4);
//        driver.findElement(By.xpath(StartDate)).sendKeys("07/21/2019 22:55:43");//here I am trying to send date
//        SeleniumUtilities1.waitPlease(2);


    }


    @AfterMethod//yeri onemli degil burda veya en sonda olabilir
    public void teardown(){
        //driver.quit();
    }

}