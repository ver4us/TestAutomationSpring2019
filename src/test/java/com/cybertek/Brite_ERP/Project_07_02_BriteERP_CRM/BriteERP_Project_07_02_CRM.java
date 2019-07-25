package com.cybertek.Brite_ERP.Project_07_02_BriteERP_CRM;

import com.cybertek.pages.Project_07_02_BriteERP_CRM.LoginPage;
import com.cybertek.utilities.Project_07_02_BriteERP_CRM.BriteERPUtils;
import com.cybertek.utilities.Project_07_02_BriteERP_CRM.ConfigurationReader;
import com.cybertek.utilities.Project_07_02_BriteERP_CRM.TestBase;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.cybertek.utilities.Project_07_02_BriteERP_CRM.ConfigurationReader.getProperty;
//import java.util.Random;


public class BriteERP_Project_07_02_CRM extends TestBase {

    LoginPage loginPage = new LoginPage();



    @Test (priority=1)
    public void listView(){
        //we are reading username from .properties file
        String username = getProperty("username");

        //we are reading password from .properties file
        String password = getProperty("password");

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
        //int randomNumber = rand.nextInt(1);
        String max = ConfigurationReader.getProperty("maxOpportunitiesToCreate");
        int number = Integer.valueOf(max);
        int randomNumber = rand.nextInt(number);
        ++randomNumber;
        System.out.println(randomNumber + " opportunities will be created");

        List<WebElement>  listOfCustomerOptions = new ArrayList<>();




        // create randomNumber of opportunities
        for(int i=0; i < randomNumber;i++){
            System.out.println("Creating Opportunity Number : " + (i+1));
            SeleniumUtils.waitPlease(3);
            //find and click the create button
            driver.findElement(By.cssSelector(BriteERP_LocatorsandMessages.createButtonLocator)).click();
            SeleniumUtils.waitPlease(3);
            // Enter Opportunity Title
            String textForOpportunityTitle = "Title " +  (i+1) + " time: " + LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm:ss"));
            driver.findElement(By.cssSelector(BriteERP_LocatorsandMessages.inputOpportunityTitleLocator)).sendKeys(textForOpportunityTitle);
            SeleniumUtils.waitPlease(1);
            //Click the Customer inputbox to see the options to select
           // WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
           // wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BriteERP_LocatorsandMessages.inputCustomerLocator)));
            driver.findElement(By.xpath(BriteERP_LocatorsandMessages.inputCustomerLocator)).click();
            SeleniumUtils.waitPlease(2);
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

            BriteERPUtils.takeAscreenShot("Test");

            // find and click create button
            driver.findElement(By.name(BriteERP_LocatorsandMessages.createOpportunityButtonLocator)).click();
        } // for(int i=0; i < randomNumber;i++){



        SeleniumUtils.waitPlease(3);

        // go back to list view
        WebElement crmListButton = driver.findElement(By.cssSelector(BriteERP_LocatorsandMessages.crmListButtonLocator));
        crmListButton.click();
        // get the number of Opportunities after creating new ones
        SeleniumUtils.waitPlease(3);
        //WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(BriteERP_LocatorsandMessages.numberOfOpportunitiesLocator))));
        numberOfOpportunitiesElement = driver.findElement(By.cssSelector(BriteERP_LocatorsandMessages.numberOfOpportunitiesLocator));
        BriteERP_LocatorsandMessages.numberOfOpportunities_after = Integer.valueOf(numberOfOpportunitiesElement.getText());
        System.out.println("Number of opportunities before adding new ones: " + BriteERP_LocatorsandMessages.numberOfOpportunities);
        System.out.println("Number of opportunities to be added: " + randomNumber);
        System.out.println("Number of opportunities after adding new ones: " + BriteERP_LocatorsandMessages.numberOfOpportunities_after);
        Assert.assertEquals(BriteERP_LocatorsandMessages.numberOfOpportunities + randomNumber,BriteERP_LocatorsandMessages.numberOfOpportunities_after);

        // reset the number of Opportunities after adding new ones
        BriteERP_LocatorsandMessages.numberOfOpportunities = BriteERP_LocatorsandMessages.numberOfOpportunities_after;

        //return to Kanban view
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.cssSelector(BriteERP_LocatorsandMessages.kanbanViewButtonLocator)).click();





        System.out.println("Total Number of Opportunities Before Deleting : " + BriteERP_LocatorsandMessages.numberOfOpportunities);

        //Select Number of opportunities to be deleted
       // randomNumber=1;
       // randomNumber = rand.nextInt(BriteERP_LocatorsandMessages.numberOfOpportunities)+1;
        max = ConfigurationReader.getProperty("maxOpportunitiesToDelete");
        number = Integer.valueOf(max);
        randomNumber = rand.nextInt(number);
        ++randomNumber;


        System.out.println("Number of Opportunities to be Deleted : " + randomNumber);

        // delete randomNumber of opportunities
        for(int i=0; i < randomNumber;i++) {


            // put all the available Opportunities to a list of WebElements called listOfOpportunities
            SeleniumUtils.waitPlease(3);
            List<WebElement> listOfOpportunities = driver.findElements(By.xpath(BriteERP_LocatorsandMessages.listOfOpportunitiesLocator));


            System.out.println("Deleting Opportunity : " + (i+1) + "/" + randomNumber);
            SeleniumUtils.waitPlease(3);
            //Select an index randomly for one of the opportunities to be deleted
            int randomNumber2 = rand.nextInt( listOfOpportunities.size());
            //int randomNumber2=0;

            System.out.println("Selected Opportunity row number : " + (randomNumber2+1));
            String OpportunityToBeDeletedLocator = BriteERP_LocatorsandMessages.listOfOpportunitiesLocator + "[" + (randomNumber2 + 1) + "]";
            String threeDotLocator = "(" + BriteERP_LocatorsandMessages.listOfThreeDotsLocator + ")[" + (randomNumber2 + 1) + "]";
            System.out.println("Locator for Opportunity that will be deleted : " + OpportunityToBeDeletedLocator);
            System.out.println("Locator for Three Dots of Opportunity that will be deleted : " + threeDotLocator);

            WebElement opportunityToBeDeletedElement = driver.findElement(By.xpath(OpportunityToBeDeletedLocator));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true)",opportunityToBeDeletedElement);
            SeleniumUtils.waitPlease(1);




            SeleniumUtils.waitPlease(4);
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(By.xpath(OpportunityToBeDeletedLocator))).perform();
            SeleniumUtils.waitPlease(4);
            action.moveToElement(driver.findElement(By.xpath(threeDotLocator))).perform();
            SeleniumUtils.waitPlease(3);
            driver.findElement(By.xpath(threeDotLocator)).click();
            String deleteButtonLocator = BriteERP_LocatorsandMessages.deleteButtonLocator + "[" + (randomNumber2 + 1) + "]";
            SeleniumUtils.waitPlease(3);
            driver.findElement(By.xpath(deleteButtonLocator)).click();
//            action.moveToElement(driver.findElement(By.xpath(OpportunityToBeDeletedLocator))).
//                    pause(1000).moveToElement(driver.findElement(By.xpath(BriteERP_LocatorsandMessages.deleteButtonLocator))).
//                    click().build().perform();
           // SeleniumUtils.waitPlease(3);
           // driver.findElement(By.xpath(BriteERP_LocatorsandMessages.deleteButtonLocator)).click();
            SeleniumUtils.waitPlease(3);
            driver.findElement(By.xpath(BriteERP_LocatorsandMessages.deleteOkButtonLocator)).click();


        } //// for(int i=0; i < randomNumber;i++)

        // go back to list view
        SeleniumUtils.waitPlease(3);
        crmListButton = driver.findElement(By.cssSelector(BriteERP_LocatorsandMessages.crmListButtonLocator));
        crmListButton.click();
        // get the number of Opportunities after creating new ones
        SeleniumUtils.waitPlease(3);
        //WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(BriteERP_LocatorsandMessages.numberOfOpportunitiesLocator))));
        numberOfOpportunitiesElement = driver.findElement(By.cssSelector(BriteERP_LocatorsandMessages.numberOfOpportunitiesLocator));
        BriteERP_LocatorsandMessages.numberOfOpportunities_after = Integer.valueOf(numberOfOpportunitiesElement.getText());

        System.out.println("Number of opportunities before deleting: " + BriteERP_LocatorsandMessages.numberOfOpportunities);
        System.out.println("Number of opportunities deleted: " + randomNumber);
        System.out.println("Number of opportunities after deleting: " + BriteERP_LocatorsandMessages.numberOfOpportunities_after);
        Assert.assertEquals(BriteERP_LocatorsandMessages.numberOfOpportunities,BriteERP_LocatorsandMessages.numberOfOpportunities_after + randomNumber);



    }///     public void createAndDeleteOpportunity() {

} ////  public class BriteERP_Project_07_02_CRM extends TestBase {