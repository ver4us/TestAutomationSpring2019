package com.cybertek.day5;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;




import java.util.concurrent.TimeUnit;

public class LocatorsPracticeID {
  // Webdriver is static because driver.manage is being called by static method
//    static WebDriver driver = getDriver("chrome");
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    //BrowserFactory
    public static void main(String[] args) throws Exception{
        //test1();
        test2();
    }


    public static void test1()throws Exception{
    driver.manage().window().maximize();
    /// selenium will wait 10 seconds for element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://practice.cybertekschool.com/login");
    driver.findElement(By.id("wooden_spoon")).click();
    Thread.sleep(3000);
    driver.quit();
    }

    public static void test2()throws Exception{
        driver.manage().window().maximize();
        /// selenium will wait 10 seconds for element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(3000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = driver.findElement(By.className("subheader")).getText();
        SeleniumUtils.verifyEquals(expectedMessage, actualMessage);
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }





//    public static WebDriver getDriver(String browser){
//
//        if (browser.equals("chrome")){
//            WebDriverManager.chromedriver().setup();
//            return new ChromeDriver();
//        }else if(browser.equals("firefox")){
//            WebDriverManager.firefoxdriver().setup();
//            return new FirefoxDriver();
//        }else{
//            throw new IllegalArgumentException("Wrong browser name!");
//        }
//    }

}
