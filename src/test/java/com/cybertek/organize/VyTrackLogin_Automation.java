package com.cybertek.organize;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
//import static java.sql.JDBCType.BOOLEAN;
//import static java.sql.JDBCType.NUMERIC;
import static javax.management.openmbean.SimpleType.STRING;
import static org.apache.poi.ss.usermodel.DataValidationConstraint.ValidationType.FORMULA;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;



public class VyTrackLogin_Automation {

    public static void main(String[] args) throws Exception {

//        FileInputStream file = new FileInputStream(new File("C:\\\\Users\\\\Kursat\\\\Desktop\\\\MagnetBoard Calender.xlsx"));
//        Workbook workbook = new XSSFWorkbook(file);
//
//        Sheet sheet = workbook.getSheetAt(0);
//
//        Map<Integer, List<String>> data = new HashMap<>();
//        int i = 0;
//        for (Row row : sheet) {
//            data.put(i, new ArrayList<String>());
//            for (Cell cell : row) {
//                switch (cell.getCellTypeEnum()) {
//                    case STRING: ... break;
//                    case NUMERIC: ... break;
//                    case BOOLEAN: ... break;
//                    case FORMULA: ... break;
//                    default: data.get(new Integer(i)).add(" ");
//                }
//            }
//            i++;
//        }
//        System.exit(0);



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // driver.get("http://practice.cybertekschool.com");
        driver.get("http://qa2.vytrack.com/user/login");

        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.id("prependedInput"));// UserName textbox
        userName.sendKeys("user45");// to enter username

        WebElement passWord = driver.findElement(By.id("prependedInput2")); //password textbox
        passWord.sendKeys("UserUser123"); // to enter password
        Thread.sleep(3000);
        WebElement loginButton = driver.findElement(By.id("_submit"));//we found login button
        loginButton.submit(); // it work only with buttons. Click method is more flexible.
        Thread.sleep(3000);


        WebElement popupMenuElement = driver.findElement(By.className("dropdown-toggle"));
        popupMenuElement.click();


        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[4]/a")).click();//we found logout button
        driver.close();
    } // main
} // public class VyTrackLogin_Automation {
