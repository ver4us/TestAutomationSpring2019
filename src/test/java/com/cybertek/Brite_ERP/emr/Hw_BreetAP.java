package com.cybertek.Brite_ERP.emr;

import com.cybertek.Brite_ERP.emr.BreetAPPUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import BreetAPPUtils;
//import SeleniumUtilities1;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hw_BreetAP {
    //In the following part I am defining the locators that I used
    WebDriver driver;
    String userNameLocator="//input[@id='login']";
    String passwordLocator = "//input[@id='password']";
    String LoginLocator="//button[@class='btn btn-primary']";
    String CreateButton="//button[@accesskey='c']";
    String evetName="//input[@name='name']";
    String StartDate="//input[@name='date_begin']";
    String endDate="//input[@name='date_end']";
    String SaveButton="//button[@accesskey='s']";
    String Takvim="//div[@class='bootstrap-datetimepicker-widget dropdown-menu usetwentyfour top']";
    String CreateButton2="//button[@accesskey='c']";
    String Opportunity="//input[@name='name']";
    String Customer="//input[@class='o_input ui-autocomplete-input']";
    String ExpectedRevenue="//input[@name='planned_revenue']";
    String Priority="//div[@name='priority']";
    String CreateButton3="//button/span[contains(text(),'Create')]";
    String CreateButton4="(//button/span[contains(text(),'Create')])[3]";
    @BeforeMethod
    public void setup(){
        //here I set up the system
        WebDriverManager.chromedriver().setup();
        //here used interface element to call chrome
        driver=new ChromeDriver();
        //I insert implicitly wait in order to handle all kind of the NoSuchElementFound exceptions
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Here I used to maximize method to Maximize the opening website
        driver.manage().window().maximize();
        //here send the webadress link
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
    //Test case 1: for this one is:User should be able to see the list the events on event module
    @Test
    public void eventManagerTest()throws IOException {
        //here call the breetUtil class
        BreetAPPUtils.navigateToModule(driver, "Events");
        SeleniumUtilities1.waitPlease(2);
        //here new element created and the adress of it is classname active.
        WebElement pageNameElement = driver.findElement(By.className("active"));
        //After opening the page the expected page is events
        String expectedMessage = "Events";
        //here the actual message is equal to pagelement's
        String actualMessage = pageNameElement.getText();
        //  Verify Dashboard page is open
        Assert.assertEquals(expectedMessage, actualMessage);
        //Event sayfasindamiyim
        System.out.println(actualMessage);//Here just amking sure that current page is opened
        SeleniumUtilities1.waitPlease(2);
        //here  I am gib=ving the adress again in order to take the screen shot.
        driver.get("http://34.220.250.213/web?#view_type=kanban&model=event.event&menu_id=128&action=142");
        SeleniumUtilities1.waitPlease(2);
        //here I am using TakescreenShot interface and casting in order to use webdriver interface
        //why screenshot: It helps me to understand the flow of application wjeter the program is working smootly or not
        //it halps most of the time when we work cross browser testing
        TakesScreenshot file=(TakesScreenshot)driver;
        //here sending the screenshot
        File source= file.getScreenshotAs(OutputType.FILE);
        //Here I want to store it
        String Event="Test";
        //here sending link and file name and show the address where to store it.
        FileUtils.copyFile(source, new File("/Users/Kursat/IdeaProjects/TestAutomationSpring2019/src/test/java/Homeworks/" + Event + ".jpg"));
        //BreetAPPUtils.takeAscreenShot("Event_page");
    }
    //Test case 2: EventManager should be able to create a new event.
    @Test
    public void eventManagerCreatingnewEvents () {
        BreetAPPUtils.navigateToModule(driver, "Events");
        SeleniumUtilities1.waitPlease(2);
        driver.findElement(By.xpath(CreateButton)).click();
        SeleniumUtilities1.waitPlease(4);
        WebElement eventNamefieldField = driver.findElement(By.xpath(evetName));
        eventNamefieldField.sendKeys("admin");//here I am trying to send event name
        SeleniumUtilities1.waitPlease(4);
        //here finding locotor for start date
        driver.findElement(By.xpath(StartDate)).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);//explicit olmadan code calismadi, oyuzden ekledik
        //we use this condition to wait until datepicker will be available
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@class='o_datepicker_input o_input']"))));
        //burda date in visible olmasini  bekliyor, cunku spinnerden sonra code aciliyor.
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='o_datepicker_input o_input']")));
        //here I am sending date
        String setDate = "07/21/2019 14:36:29";
        driver.findElement(By.xpath("//input[@class='o_datepicker_input o_input']")).sendKeys(setDate);
        SeleniumUtilities1.waitPlease(4);
        //here sending the date for the end date
        String endDate1 = "07/28/2019 23:08:48";
        driver.findElement(By.xpath(endDate)).sendKeys(endDate1);
        SeleniumUtilities1.waitPlease(4);
        //here after filling the requireed parts I click the save button
        WebElement Save = driver.findElement(By.xpath(SaveButton));
        Save.click();
        System.out.println(Save.getText());

    }
    }