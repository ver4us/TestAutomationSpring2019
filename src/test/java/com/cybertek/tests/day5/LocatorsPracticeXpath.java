package com.cybertek.tests.day5;
import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

//tag[@attribute='value']
//*[@attribute='value']
//* means any tag
//tag[text()='Some text']
//*[contains(@attribute,'value')] - partial attribute
public class LocatorsPracticeXpath {
    static WebDriver driver = BrowserFactory.getDriver("chrome");
    public static void main(String[] args) throws Exception{
        test1();
    } // main end

    public static void test1() throws Exception{
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/sign_up");

        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Ahmet Can");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ahmetcan343424@gmail.com");
        driver.findElement(By.xpath("//button[@name='wooden_spoon']")).click();

        //*[@id="login"]/button

        try{
            Thread.sleep(3000);
        } catch (ArithmeticException e){
            System.out.println("Exception caught!");
        }


        driver.close();

    }    // test1()


} // class end
