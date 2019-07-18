package com.cybertek.day8_testng_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task {
    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test(priority=1)
    public void test1(){

        WebElement year = driver.findElement(By.id("year"));
        Select dropdownSelect = new Select(year);
        String selected = dropdownSelect.getFirstSelectedOption().getText();
        Assert.assertTrue(selected.equals("2019"));




    }

    @Test (priority=0)
    public void test2(){
        WebElement month = driver.findElement(By.id("month"));
        Select dropdownSelect1 = new Select(month);
        String selected = dropdownSelect1.getFirstSelectedOption().getText();
        Assert.assertTrue(selected.equals("July"));
    }

    @Test (priority=0)
    public void test3(){
        WebElement day = driver.findElement(By.id("day"));
        Select dropdownSelect2 = new Select(day);
        String selected = dropdownSelect2.getFirstSelectedOption().getText();
        Assert.assertTrue(selected.equals("7"));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
