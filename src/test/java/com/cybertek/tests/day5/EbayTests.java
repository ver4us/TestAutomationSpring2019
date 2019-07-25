package com.cybertek.tests.day5;
import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class  EbayTests {
    static WebDriver driver2 = BrowserFactory.getDriver("chrome");
    public static void main(String[] args) throws Exception{
        // test1();
        test3();
    }


    public static void test3() throws Exception {
        driver2.manage().window().maximize();
        driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver2.get("http://ebay.com");

        WebElement name = driver2.findElement(By.id("gh-ac"));// UserName textbox
        name.sendKeys("Java Book");// to enter username

        Thread.sleep(3000);
        WebElement loginButton = driver2.findElement(By.id("gh-btn"));//we found login button
        loginButton.submit(); // it work only with buttons. Click method is more flexible.


        Thread.sleep(3000);


        String results = driver2.findElement(By.className("srp-controls__count-heading")).getText();

        System.out.println(results);

        driver2.close();
    }





}
