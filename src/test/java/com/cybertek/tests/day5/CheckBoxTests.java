package com.cybertek.tests.day5;
import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxTests {
    static WebDriver driver = BrowserFactory.getDriver("chrome");
    public static void main(String[] args) throws Exception {
        //test1();
        test2();
    }

    public static void openCheckBoxesPage() {

        driver.manage().window().maximize();
        SeleniumUtils.waitPlease(10);
        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement checkboxesLogo = driver.findElement(By.tagName("h3"));
        if(checkboxesLogo.isDisplayed()){
            System.out.println("DISPLAY PASSED");
        }else{
            System.out.println("DISPLAY FAILED");
        }

    }

    public static void test1(){
        openCheckBoxesPage();
        SeleniumUtils.waitPlease(5);
        SeleniumUtils.openPage("checkbox", driver);
        SeleniumUtils.waitPlease(5);
        if (!driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected()){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        if (driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected()){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        driver.close();
    } // test1()

    public static void test2(){
        SeleniumUtils.waitPlease(3);
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"][2]"));
        SeleniumUtils.waitPlease(3);
        checkbox1.click();
        SeleniumUtils.waitPlease(3);
        checkbox2.click();
        SeleniumUtils.waitPlease(3);
        if(checkbox1.isSelected()&&(!checkbox2.isSelected())){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        SeleniumUtils.waitPlease(6);
        driver.close();
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
