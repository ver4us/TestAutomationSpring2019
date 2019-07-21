package com.cybertek.tests.day5;
import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TaskJuly02_VerifyAmazonTitle {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
         //TaskJuly02_VerifyAmazonTitle w  = new TaskJuly02_VerifyAmazonTitle();
         //w.driver.get();

        test();
    }

    public static void test()  {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://amazon.com");
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement inputSearch = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        inputSearch.sendKeys("Bicycle");
        driver.findElement(By.xpath("//input[@class=\"nav-input\"][@value=\"Go\"]")).click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (driver.getTitle().contains("Bicycle")) System.out.println("Title contains Bicycle");
        else System.out.println("Title does not contain Bicycle");
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.close();
    }
}
