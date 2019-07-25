package com.cybertek.tests.day17_webtables_day2;

import com.cybertek.Brite_ERP.Project_07_02_BriteERP_CRM.BriteERP_LocatorsandMessages;
import com.cybertek.pages.Project_07_02_BriteERP_CRM.LoginPage;
import com.cybertek.utilities.Project_07_02_BriteERP_CRM.ConfigurationReader;
import com.cybertek.utilities.Project_07_02_BriteERP_CRM.TestBase;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BriteERP_ReadTable extends TestBase {
    static String successfulLoginLocator = "o_thread_title";   //classname
    static String crmLocator = "//a//span[contains(text(),'CRM')]"; // xpath
    static String crmPageTextLocator = "//li[.='Pipeline']";  //xpath
    static String crmListButtonLocator = "button[accesskey='l']";   //css locator
    static String createButtonLocator = "button[accesskey='c']";   //css locator
    static String numberOfOpportunitiesLocator = "span.o_pager_limit"; // css locator
    //static String numberOfOpportunitiesLocator = "div.o_cp_pager div"; // css locator


    static String loginExpectedMessage = "Congratulations, your inbox is empty";
    static String CRMExpectedMessage = "Pipeline";

    static int numberOfOpportunities;
    static int numberOfOpportunities_after;
    LoginPage loginPage = new LoginPage();



    @Test
    public void readTable(){
        //we are reading username from .properties file
        String username = ConfigurationReader.getProperty("username");

        //we are reading password from .properties file
        String password = ConfigurationReader.getProperty("password");

        //login to BriteERP website as events crm manager which is specified in configuration.properties
        loginPage.login(username,password);

        //check if you have logged in successfully by verifying with the text of an element
        WebElement loginTextElement = driver.findElement(By.className(successfulLoginLocator));
        Assert.assertEquals(loginExpectedMessage, loginTextElement.getText());

        //Enter the CRM page
        WebElement crmElement = driver.findElement(By.xpath(crmLocator));
        crmElement.click();

        //check if you have logged in to CRM successfully by verifying with the text of an element
        WebElement crmPageTextElement = driver.findElement(By.xpath(crmPageTextLocator));
        Assert.assertEquals(CRMExpectedMessage, crmPageTextElement.getText());

        // view the page as list
        //WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(crmListButtonLocator))));
        WebElement crmListButton = driver.findElement(By.cssSelector(crmListButtonLocator));
        crmListButton.click();



        WebElement table = driver.findElement(By.xpath("//table/tbody/tr/td[2]"));
        System.out.println(table.getText());
    }


}