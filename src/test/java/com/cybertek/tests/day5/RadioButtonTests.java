package com.cybertek.tests.day5;
import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonTests {
    static WebDriver driver = BrowserFactory.getDriver("chrome");
    public static void main(String[] args) throws Exception {
        openRadioButtonPage();
       // test1();
       // test2();
        //test3();
        test4();
        driver.close();
    }

    public static void openRadioButtonPage() throws Exception {

        driver.manage().window().maximize();
        SeleniumUtils.waitPlease(2);
        driver.get("http://practice.cybertekschool.com/radio_buttons");

    }

    public static void test1(){
        SeleniumUtils.waitPlease(5);
        WebElement blueBtn = driver.findElement(By.id("blue"));
        if(blueBtn.isSelected()){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
    } // test1()

    public static void test2(){
        SeleniumUtils.waitPlease(5);
        WebElement blackBtn  = driver.findElement(By.id("black"));
        WebElement greenBTN = driver.findElement(By.id("green"));
        if(blackBtn.isEnabled() && (!greenBTN.isEnabled())){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
    } // test2()
    public static void test3(){
        SeleniumUtils.waitPlease(5);
        WebElement blueBtn  = driver.findElement(By.id("blue"));
        if (blueBtn.isSelected()) System.out.println("Passed");
        else System.out.println("Failed");
        SeleniumUtils.waitPlease(2);
        WebElement blackBtn = driver.findElement(By.id("black"));
        blackBtn.click();
        SeleniumUtils.waitPlease(2);
        if (blackBtn.isSelected()) System.out.println("Passed");
        else System.out.println("Failed");
        SeleniumUtils.waitPlease(2);
        if (!blueBtn.isSelected()) System.out.println("Passed");
        else System.out.println("Failed");

    } // test3()


    public static void test4(){
        List<WebElement> listOfRadioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        int counter=0;

        for(WebElement radioButton:listOfRadioButtons ){

            if (radioButton.isSelected()){
                System.out.println(radioButton.getText().toString());
                System.out.println(radioButton.getAttribute( "id"));
                counter++;
            }
        }

        System.out.println(counter);
    } // test4()



}
