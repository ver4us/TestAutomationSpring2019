package com.cybertek.organize;

//import com.sun.tools.javac.util.Assert;
import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CybertekPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        Thread.sleep(3000);

        WebElement username = driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/div/input"));
        username.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/div/input"));
        password.sendKeys("SuperSecretPasswords");

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"wooden_spoon\"]"));
        submit.click();

        Thread.sleep(3000);

        WebElement loggedin = driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String actualMessage = loggedin.getText();
       // System.out.println(loggedin.getText());
        String expectedMessage = "Your password is invalid";

        SeleniumUtils.verifyContains(expectedMessage,actualMessage);


        driver.quit();
    }
}