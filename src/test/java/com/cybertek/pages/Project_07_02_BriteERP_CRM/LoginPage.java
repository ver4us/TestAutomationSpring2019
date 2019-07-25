package com.cybertek.pages.Project_07_02_BriteERP_CRM;


//import com.cybertek.utilities.Driver;
import com.cybertek.utilities.Project_07_02_BriteERP_CRM.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginPage {
    String userNameLocator = "login";    //id
    String passwordLocator = "password"; //id

    public void login(String userName, String password){
        Driver.getDriver().findElement(By.id(userNameLocator)).sendKeys(userName);
        Driver.getDriver().findElement(By.id(passwordLocator)).sendKeys(password, Keys.ENTER);
    }
}