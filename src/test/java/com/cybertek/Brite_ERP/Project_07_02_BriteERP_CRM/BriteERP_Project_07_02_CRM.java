package com.cybertek.Brite_ERP.Project_07_02_BriteERP_CRM;

import com.cybertek.pages.Project_07_02_BriteERP_CRM.LoginPage;
import com.cybertek.utilities.Project_07_02_BriteERP_CRM.ConfigurationReader;
import com.cybertek.utilities.Project_07_02_BriteERP_CRM.TestBase;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
//import java.util.Random;


public class BriteERP_Project_07_02_CRM extends TestBase {

    LoginPage loginPage = new LoginPage();



    @Test (priority=1)
    public void listView(){
        //we are reading username from .properties file
        String username = ConfigurationReader.getProperty("username");

        //we are reading password from .properties file
        String password = ConfigurationReader.getProperty("password");

        //login to BriteERP website as events crm manager which is specified in configuration.properties
        loginPage.login(username,password);

        //check if you have logged in successfully by verifying with the text of an element
        WebElement loginTextElement = driver.findElement(By.className(BriteERP_LocatorsandMessages.successfulLoginLocator));
        Assert.assertEquals(BriteERP_LocatorsandMessages.loginExpectedMessage, loginTextElement.getText());

        //Enter the CRM page
        WebElement crmElement = driver.findElement(By.xpath(BriteERP_LocatorsandMessages.crmLocator));
        crmElement.click();

        //check if you have logged in to CRM successfully by verifying with the text of an element
        WebElement crmPageTextElement = driver.findElement(By.xpath(BriteERP_LocatorsandMessages.crmPageTextLocator));
        Assert.assertEquals(BriteERP_LocatorsandMessages.CRMExpectedMessage, crmPageTextElement.getText());

        // view the page as list
        //WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(BriteERP_LocatorsandMessages.crmListButtonLocator))));
        WebElement crmListButton = driver.findElement(By.cssSelector(BriteERP_LocatorsandMessages.crmListButtonLocator));
        crmListButton.click();
    }

    @Test (priority = 2)
    public void createAndDeleteOpportunity() {

        listView();

        // get the number of Opportunities before we create new ones
        SeleniumUtils.waitPlease(1);
        //WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(BriteERP_LocatorsandMessages.numberOfOpportunitiesLocator))));
        WebElement numberOfOpportunitiesElement = driver.findElement(By.cssSelector(BriteERP_LocatorsandMessages.numberOfOpportunitiesLocator));
        BriteERP_LocatorsandMessages.numberOfOpportunities = Integer.valueOf(numberOfOpportunitiesElement.getText());
        System.out.println(BriteERP_LocatorsandMessages.numberOfOpportunities);

        // go back to Kanban view
        driver.findElement(By.cssSelector(BriteERP_LocatorsandMessages.kanbanViewButtonLocator)).click();



        //create random number for opportunities between 1 and 5
        Random rand = new Random();
        int randomNumber = rand.nextInt(5);
        ++randomNumber;
        System.out.println(randomNumber + " opportunities will be created");

        List<WebElement>  listOfCustomerOptions = new ArrayList<>();




        // create randomNumber of opportunities
        for(int i=0; i < randomNumber;i++){
            System.out.println("Creating Opportunity Number : " + (i+1));
            SeleniumUtils.waitPlease(1);
            //find and click the create button
            driver.findElement(By.cssSelector(BriteERP_LocatorsandMessages.createButtonLocator)).click();
            SeleniumUtils.waitPlease(1);
            // Enter Opportunity Title
            String textForOpportunityTitle = "Title " +  (i+1) + " time: " + LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm:ss"));
            driver.findElement(By.cssSelector(BriteERP_LocatorsandMessages.inputOpportunityTitleLocator)).sendKeys(textForOpportunityTitle);
            SeleniumUtils.waitPlease(1);
            //Click the Customer inputbox to see the options to select
           // WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
           // wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BriteERP_LocatorsandMessages.inputCustomerLocator)));
            driver.findElement(By.xpath(BriteERP_LocatorsandMessages.inputCustomerLocator)).click();
            SeleniumUtils.waitPlease(3);
            // put all the available Customer Input Box options to a list of WebElements called listOfCustomerOptions
            listOfCustomerOptions = driver.findElements(By.xpath(BriteERP_LocatorsandMessages.listOfCustomerOptionsLocator));
            // select a random number that will be used as index to select Customer Options
            System.out.println("Size of the Customer Options is : " + listOfCustomerOptions.size());
            int randomNumber2 = rand.nextInt(listOfCustomerOptions.size()-2);
            //++randomNumber2;
            System.out.println("# of The Customer Option will be : " + (randomNumber2+1));

            // select and click the Customer Options whose index was randomly selected above
            listOfCustomerOptions.get(randomNumber2).click();
            // select random value to be put into Expected Revenue inputbox
            int expectedRevenue = rand.nextInt(300);
            int expectedRevenueDecimal = rand.nextInt(100);
            // convert the value of Expected Revenue into string
            String expectedRevenueString;
            if (expectedRevenueDecimal > 9)
                expectedRevenueString = String.valueOf(expectedRevenue) + "." + String.valueOf(expectedRevenueDecimal);
            else
                expectedRevenueString = String.valueOf(expectedRevenue) + ".0" + String.valueOf(expectedRevenueDecimal);
            // put the randomly specified Expected Revenue value into Expected Revenue inputbox
            SeleniumUtils.waitPlease(1);
           // driver.findElement(By.name(BriteERP_LocatorsandMessages.expectedRevenueLocator)).sendKeys(expectedRevenueString);
            WebElement expectedRevenueInput = driver.findElement(By.xpath(BriteERP_LocatorsandMessages.expectedRevenueLocator));
            expectedRevenueInput.clear();
            expectedRevenueInput.sendKeys(expectedRevenueString);

            // Select a random value between 1-3 to select one of the priorities
            int randomNumber3 = rand.nextInt(3);
            ++randomNumber3;
            System.out.println("Random number for the priority locator is : " + randomNumber3);
            // specify the locator for the pririty that will be selected
            SeleniumUtils.waitPlease(3);
            String priorityLocator = "//table//tbody//tr[4]//td[2]//div//a[@data-index='" + randomNumber3 + "']";
            System.out.println("Priority Locator is " + priorityLocator);
            //find and click the priority button
            SeleniumUtils.waitPlease(1);
            driver.findElement(By.xpath(priorityLocator)).click();
            // find and click create button
            driver.findElement(By.name(BriteERP_LocatorsandMessages.createOpportunityButtonLocator)).click();



        }






        //Select one of the opportunities to delete randomly



      //  driver.findElement(By.xpath("(//a[@class='dropdown-toggle btn'])[")).click();



    }

}