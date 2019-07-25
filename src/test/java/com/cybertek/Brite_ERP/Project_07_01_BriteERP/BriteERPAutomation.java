package com.cybertek.Brite_ERP.Project_07_01_BriteERP;

import com.cybertek.Brite_ERP.Project_07_01_BriteERP.BriteERPUtils;
import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;




public class BriteERPAutomation {

    WebDriver driver;
    String successfulLoginLocator = "o_thread_title";
    String successfulExpensesLocator = "//li[@class='active'][contains(text(),'My Expenses to Submit')]";
    String createButtonLocator = "//button[@class='btn btn-primary btn-sm o_list_button_add']";
    String productInputLocator = "(//input[contains(@id,'o_field_input')])[2]";
    String apple80Locator = "//li/a[contains(text(),'Apple80')]";
    String unitPriceLocator = "(//input[contains(@id,'o_field_input')])[3]";
    String unitQuantityLocator = "(//input[contains(@id,'o_field_input')])[4]";
    String employeeInputLocator = "(//input[contains(@id,'o_field_input')])[9]";
    String DavidSamsonLocator = "//li/a[contains(text(),'David Samson')]";
    String saveButtonLocator = "//button[contains(text(),'Save')][@accesskey='s']";
    String messageContentLocator = "//p[.='Expense created']";

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get("http://34.220.250.213/web/login");
    }

    @Test (priority = 1)
    public void createNewExpense_As_ExpenseManager_PositiveValue(){
        //login to BriteERP website as expenses manager
        BriteERPUtils.login(driver,"in_ex_manager3@info.com","LLighg90" );
        String expectedMessage = "Congratulations, your inbox is empty";
        //check if you have logged in successfully by verifying with the text of an element
        Assert.assertEquals(expectedMessage, driver.findElement(By.className(successfulLoginLocator)).getText());
        // find and click the expenses option from the menu
        driver.findElement(By.partialLinkText("Expenses")).click();
        //Check if Expenses Page is displayed successfully
        expectedMessage = "My Expenses to Submit";
        //check if the Expenses page is successfully displayed
        Assert.assertEquals(expectedMessage, driver.findElement(By.xpath(successfulExpensesLocator)).getText());
        // Find and click the create button
        driver.findElement(By.xpath(createButtonLocator)).click();
        //Find the product input
        WebElement productInput = driver.findElement(By.xpath(productInputLocator));
        // Click the product input to view the selectable options of Product input
        productInput.click();
        // find the option that has Apple80
        WebElement apple80Element = driver.findElement(By.xpath(apple80Locator));
        //Click the option that has Apple80
        apple80Element.click();
        // Make an explicit wait to make sure unit price input is available to enter text
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(unitPriceLocator))));
        SeleniumUtils.waitPlease(3);
        //find the unit price input element
        WebElement unitPriceInput = driver.findElement(By.xpath(unitPriceLocator));
        // Clear the unit price input box
        unitPriceInput.clear();
        // enter value to unit price input box
        unitPriceInput.sendKeys("50");
        // find the unit Quantity input
        WebElement unitQuantityInput = driver.findElement(By.xpath(unitQuantityLocator));
        //clear the unit quantity input box
        unitQuantityInput.clear();
        // enter value to the unit quantity input box
        unitQuantityInput.sendKeys("10");
        //find the element for Employee input box
        WebElement employeeInput = driver.findElement(By.xpath(employeeInputLocator));
        //click the Employee input box to see options
        employeeInput.click();
        // select the Employee David Samson from the list that opens
        driver.findElement(By.xpath("//li/a[contains(text(),'David Samson')]")).click();
        //find the element for the save button
        WebElement saveButton = driver.findElement(By.xpath(saveButtonLocator));
        //click the save button element
        saveButton.click();
        // //specify the message that should be displayed
        expectedMessage = "Expense created";
        //find the element for the message content
        String actualMessage = driver.findElement(By.xpath(messageContentLocator)).getText();
        // check if expense was saved successfully by looking at the message content
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Test (priority = 2)
    public void createNewExpense_As_ExpenseManager_Negative_Value(){
        //login to BriteERP website as expenses manager
        BriteERPUtils.login(driver,"in_ex_manager3@info.com","LLighg90" );
        String expectedMessage = "Congratulations, your inbox is empty";
        //check if you have logged in successfully by verifying with the text of an element
        Assert.assertEquals(expectedMessage, driver.findElement(By.className(successfulLoginLocator)).getText());
        // find and click the expenses option from the menu
        driver.findElement(By.partialLinkText("Expenses")).click();
        //Check if Expenses Page is displayed successfully
        expectedMessage = "My Expenses to Submit";
        //check if the Expenses page is successfully displayed
        Assert.assertEquals(expectedMessage, driver.findElement(By.xpath(successfulExpensesLocator)).getText());
        // Find and click the create button
        driver.findElement(By.xpath(createButtonLocator)).click();
        //Find the product input
        WebElement productInput = driver.findElement(By.xpath(productInputLocator));
        // Click the product input to view the selectable options of Product input
        productInput.click();
        // find the option that has Apple80
        WebElement apple80Element = driver.findElement(By.xpath(apple80Locator));
        //Click the option that has Apple80
        apple80Element.click();
        // Make an explicit wait to make sure unit price input is available to enter text
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(unitPriceLocator))));
        SeleniumUtils.waitPlease(3);
        //find the unit price input element
        WebElement unitPriceInput = driver.findElement(By.xpath(unitPriceLocator));
        // Clear the unit price input box
        unitPriceInput.clear();
        // enter value to unit price input box
        unitPriceInput.sendKeys("-50");
        // find the unit Quantity input
        WebElement unitQuantityInput = driver.findElement(By.xpath(unitQuantityLocator));
        //clear the unit quantity input box
        unitQuantityInput.clear();
        // enter value to the unit quantity input box
        unitQuantityInput.sendKeys("10");
        //find the element for Employee input box
        WebElement employeeInput = driver.findElement(By.xpath(employeeInputLocator));
        //click the Employee input box to see options
        employeeInput.click();
        // select the Employee David Samson from the list that opens
        driver.findElement(By.xpath("//li/a[contains(text(),'David Samson')]")).click();
        //find the element for the save button
        WebElement saveButton = driver.findElement(By.xpath(saveButtonLocator));
        //click the save button element
        saveButton.click();
        // //specify the message that should be displayed
        expectedMessage = "Expense created";
        //find the element for the message content
        String actualMessage = driver.findElement(By.xpath(messageContentLocator)).getText();
        // check if expense was saved successfully by looking at the message content
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @AfterMethod
    public void tearDown(){
        // driver.close();
    }

}


