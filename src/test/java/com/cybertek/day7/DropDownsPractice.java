package com.cybertek.day7;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownsPractice {

    static WebDriver driver = BrowserFactory.getDriver("chrome");


    public static void main(String[] args) {
        openPage("http://practice.cybertekschool.com/dropdown");
        SeleniumUtils.waitPlease(2);
        test1();
       // test2();
        //test3();
      //  test4();
       // test5();
       // test6();
        driver.quit();
    }

    public static void openPage(String website){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(website);
        String expected = "Dropdown List";
        WebElement element = driver.findElement(By.xpath("//h3[text()='Dropdown List']"));
        SeleniumUtils.verifyIsDisplayed(element);
        //String actual = driver.findElement(By.tagName("h3")).getText();
        //String actual = driver.findElement(By.xpath("//h3[text()='Dropdown List']")).getText();
    } // openPage()

    public static void test1(){
        WebElement dropdown1 = driver.findElement(By.id("dropdown"));
        Select dropdownSelect = new Select(dropdown1);
        String selected = dropdownSelect.getFirstSelectedOption().getText();
        System.out.println(selected);

    }

    public static void test2(){
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
        List<WebElement> states = dropDownSelect.getOptions();
        for (WebElement element: states){
            System.out.println(element.getText());
        }
        //let's select virginia
        //we have to use object of Select class
        dropDownSelect.selectByVisibleText("Virginia");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Texas");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("California");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Kansas");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("New Jersey");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Florida");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Tennessee");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Ohio");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Colorado");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Nebraska");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Arkansas");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("District Of Columbia");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Pennsylvania");
    }


    public static void test3(){
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
        List<WebElement> states = dropDownSelect.getOptions();
        for (WebElement element: states){
            SeleniumUtils.waitPlease(1);
            dropDownSelect.selectByVisibleText(element.getText());
        }
    }

    public static void test4(){
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
        dropDownSelect.selectByValue("PA");
        SeleniumUtils.waitPlease(2);
        String expected = "Pennsylvania";
        String actual = dropDownSelect.getFirstSelectedOption().getText();
        SeleniumUtils.verifyEquals(expected, actual);
    }

    public static void test5(){
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByIndex(5);
        SeleniumUtils.waitPlease(2);
    }

    public static void test6(){
        WebElement multiSelectionWebElement = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select multiSelectionSelect = new Select(multiSelectionWebElement);
        SeleniumUtils.waitPlease(2);
        multiSelectionSelect.selectByVisibleText("Java");
        SeleniumUtils.waitPlease(2);
        multiSelectionSelect.selectByVisibleText("JavaScript");
        SeleniumUtils.waitPlease(2);

//        multiSelectionSelect.deselectAll();
//        multiSelectionSelect.deselectByIndex();
//        multiSelectionSelect.deselectByValue();
//        multiSelectionSelect.deselectByVisibleText();
//        multiSelectionSelect.isMultiple();
//        Also write a method that will check values in multiselect are stored in the alphabetical order
//        Also write a method that will check values in dropdown are stored in the alphabetical order
//        Try to automate non-select dropdown


    }



} // public class DropDownsPractice {
