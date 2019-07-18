package com.cybertek.organize;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
public class VyTrackLogin {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       // driver.get("http://practice.cybertekschool.com");
        driver.get("http://qa2.vytrack.com/user/login");

        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.id("prependedInput"));// UserName textbox
        userName.sendKeys("user45");// to enter username

        //driver.findElement(By.id("prependedInput")).sendKeys("user45");
//        Thread.sleep(5000);
//        userName.clear();
//        userName.sendKeys("Uulkan");// to enter username
//
//
//        Thread.sleep(15000);
//        driver.close();

        WebElement passWord = driver.findElement(By.id("prependedInput2")); //password textbox
        passWord.sendKeys("UserUser123"); // to enter password
        Thread.sleep(3000);
        WebElement loginButton = driver.findElement(By.id("_submit"));//we found login button
        loginButton.submit(); // it work only with buttons. Click method is more flexible.
        Thread.sleep(3000);


        WebElement popupMenuElement = driver.findElement(By.className("dropdown-toggle"));
        popupMenuElement.click();

//        WebElement popupMenuLogout = driver.findElement(By.className("no-hash"));
//        popupMenuLogout.click();

//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/a")).click();
        Thread.sleep(5000);
       // driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[4]/a")).click();//we found logout button
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[4]/a")).click();//we found logout button
        Thread.sleep(5000);
        driver.close();




       // driver.close();






    }
}
