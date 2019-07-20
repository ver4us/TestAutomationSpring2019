package com.cybertek.Brite_ERP.emr;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class BreetAPPUtils {

    static WebDriver driver;


    private static String usernameLocator="login";
    private static String passwordLocator="password";
    public static void login(WebDriver driver, String username, String password){
        driver.findElement(By.id(usernameLocator)).sendKeys(username);
        //Keys.ENTER means click enter after entering password
        //in this way, we don't need to click login button
        driver.findElement(By.id(passwordLocator)).sendKeys(password, Keys.ENTER);
        SeleniumUtilities1.waitPlease(3);
    }
    public static void navigateToModule(WebDriver driver, String tab){
        String tabLocator = "//span[contains(text(),'"+tab+"') and contains(@class, 'oe_menu_text')]";
        // String moduleLocator = "//span[contains(text(),'"+module+"') and contains(@class, 'oe_menu_text')]";
        driver.findElement(By.xpath(tabLocator)).click();
        SeleniumUtilities1.waitPlease(1);
        //driver.findElement(By.xpath(moduleLocator)).click();
        //SeleniumUtilities1.waitPlease(2);

    }

    public static void takeAscreenShot(String Event) throws IOException{

        //Here I am taking the screenshot
        TakesScreenshot file=(TakesScreenshot)driver;
        File source= file.getScreenshotAs(OutputType.FILE);
        //Here I want to store it
        FileUtils.copyFile(source, new File("/Users/Kursat/IdeaProjects/TestAutomationSpring2019/src/test/java/Homeworks/" + Event + ".jpg"));
    }
}