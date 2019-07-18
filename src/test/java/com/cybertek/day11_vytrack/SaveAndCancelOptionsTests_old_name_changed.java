package com.cybertek.day11_vytrack;
/*
"Test case: Save and Cancel options
Login as sales manager
Go to Activities --> Calendar Events
Click on Create Calendar Event
Verify Cancel button is displayed
Verify Save And Close button is displayed
Verify Save And Close dropdown option is displayed
Verify Save And New dropdown option is displayed
Verify Save dropdown option is displayed

"
 */
import com.cybertek.utilities.SeleniumUtils;
import com.cybertek.utilities.VYTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SaveAndCancelOptionsTests_old_name_changed {

    WebDriver driver;
    String createCalendarEventButtonLocator = "a[title='Create Calendar event']";
    String cancelButtonLocator = "a[title='Cancel']";
    //locators for save and close dropdown
    String saveAndCloseButtonLocator = "//div/button[contains(text(),'Save and Close')]";
    String saveAndCloseDropdownLocator = "a[class='btn-success btn dropdown-toggle']";
    String saveAndCloseOptionLocator = "//li/button[contains(text(),'Save and Close')]";
    String saveAndNewOptionLocator = "//li/button[contains(text(),'Save and New')]";
    String saveOptionLocator = "(//li/button[contains(text(),'Save')])[3]";


    @BeforeMethod
    public void setup() {
        //driver setup
        WebDriverManager.chromedriver().setup();
        //to initialize driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");
        VYTrackUtils.login(driver, "salesmanager253", "UserUser123");
    }

    @Test
    public void verifyCancelButton() {
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtils.waitPlease(2);
        Assert.assertTrue(driver.findElement(By.cssSelector(cancelButtonLocator)).isDisplayed());
    }

    @Test
    public void verifySaveAndCloseDropdown() {
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtils.waitPlease(2);

        //verify save and close button is displayed (visible)
        Assert.assertTrue(driver.findElement(By.xpath(saveAndCloseButtonLocator)).isDisplayed());

        //click on toggle to make dropdown options visible
        //driver.findElement(By.cssSelector(saveAndCloseDropdownLocator)).click();
        SeleniumUtils.clickWithWait(driver, By.cssSelector(saveAndCloseDropdownLocator), 4);
        //verify dropdown options are visible
        Assert.assertTrue(driver.findElement(By.xpath(saveAndCloseOptionLocator)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(saveAndNewOptionLocator)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(saveOptionLocator)).isDisplayed());
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}