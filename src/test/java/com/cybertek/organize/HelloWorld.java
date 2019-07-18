package com.cybertek.organize;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup(); //setup webdriver
        //driver will give us access to the browser
        WebDriver driver = new ChromeDriver(); // create object of chrome driver
        driver.manage().window().maximize(); // open browser maximized
        driver.get("http://practice.cybertekschool.com/forgot_password"); // open url

        //Faker faker = new Faker();
//        Faker faker = new Faker();
//        System.out.println(faker.internet().emailAddress());
//        System.out.println("Hello World");
//        for (int i=0;i<100;i++) {
//            System.out.println(faker.name().firstName());
//        }

        WebElement submitButton = driver.findElement(By.id("form_submit"));//we found submit button
        WebElement emailInputBox = driver.findElement(By.name("email")); //we found input box
        emailInputBox.sendKeys("kyavuz2019@gmail.com"); // to enter text into input box
        Thread.sleep(3000);
        submitButton.submit(); // it work only with buttons. Click method is more flexible.
        Thread.sleep(10000);
        driver.close();
    }
}
