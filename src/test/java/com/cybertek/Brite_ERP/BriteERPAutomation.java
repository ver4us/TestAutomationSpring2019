package com.cybertek.Brite_ERP;

import com.cybertek.utilities.BriteERPUtils;
import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;




public class BriteERPAutomation {

    WebDriver driver;
    String successfulLoginLocator = "o_thread_title";

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get("http://34.220.250.213/web/login");
    }

    @Test
    public void createNewExpense_As_ExpenseManager(){
        BriteERPUtils.login(driver,"in_ex_manager3@info.com","LLighg90" );
        String expected_message = "Congratulations, your inbox is empty";
        Assert.assertEquals(expected_message, driver.findElement(By.className(successfulLoginLocator)).getText());
        driver.findElement(By.partialLinkText("Expenses")).click();
    }


    @AfterMethod
    public void tearDown(){
        //driver.close();
    }

}


