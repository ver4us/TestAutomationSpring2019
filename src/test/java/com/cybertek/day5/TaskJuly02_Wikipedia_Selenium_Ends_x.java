package com.cybertek.day5;
import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TaskJuly02_Wikipedia_Selenium_Ends_x {
    static WebDriver driver = BrowserFactory.getDriver("chrome");
    public static void main(String[] args)  {
        test();
    }

    public static void test() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://wikipedia.org");
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        SeleniumUtils.waitPlease(3);
        WebElement inputSearch = driver.findElement(By.xpath("//input[@id='searchInput']"));
        inputSearch.sendKeys("selenium webdriver", Keys.ENTER);
        //driver.findElement(By.xpath("//button[@class=\"pure-button pure-button-primary-progressive\"]")).click();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        SeleniumUtils.waitPlease(3);
        //driver.findElement(By.linkText("Selenium (software)")).click();
        driver.findElement(By.partialLinkText("Selenium")).click();
       // driver.getCurrentUrl();
        //System.out.println(driver.getCurrentUrl().toString());
        System.out.println(driver.getCurrentUrl());
        if (driver.getCurrentUrl().endsWith("x")){

            System.out.println("passed");

        }else
        {

            System.out.println("failed");
        }


//        System.out.println(driver.getTitle());
//        if (driver.getTitle().endsWith("x")) System.out.println("Title ends with x");
//        else System.out.println("Title does not end with x");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.close();
    }
}
