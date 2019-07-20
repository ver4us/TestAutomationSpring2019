package com.cybertek.Brite_ERP;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BriteERPUtils {
    //we don't want to access these variables outside
    private static String usernamelocator = "login";
    private static String passwordLocator = "password";

    public static void login(WebDriver driver, String username, String password){
        driver.findElement(By.id(usernamelocator)).sendKeys(username);
        //Keys.ENTER means click enter after entering password
        //in this way, we don't need to click login button
        driver.findElement(By.id(passwordLocator)).sendKeys(password, Keys.ENTER);
        //SeleniumUtils.waitPlease(3);
    }

}
