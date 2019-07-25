package com.cybertek.Brite_ERP.emr;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cybertek.Brite_ERP.emr.SeleniumUtilities1;

import java.util.concurrent.TimeUnit;

public class Synchronization {
    public static void main(String[] args){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        //here used interface element to call chrome
        driver=new ChromeDriver();
        //I insert implicitly wait in order to handle all kind of the NoSuchElementFound exceptions
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Here I used to maximize method to Maximize the opening website
        driver.manage().window().maximize();
        //here send the webadress link
        driver.get("https://www.priceline.com/hotels/");
        //SeleniumUtilities1.waitPlease(1000);
        driver.findElement(By.xpath("//input[@id='location']")).sendKeys("NYC");
        //SeleniumUtilities1.waitPlease(1000);
        driver.findElement(By.id("location")).sendKeys(Keys.TAB);

        driver.findElement(By.xpath("//input[@name='date-range']")).click();
        driver.findElement(By.xpath("//div[@aria-label='July 23, 2019']")).click();
        driver.findElement(By.xpath("//div[@aria-label='July 25, 2019']")).click();
        WebElement dropdownState = driver.findElement(By.id("rooms"));
        Select dropDownSelect = new Select(dropdownState);
        dropDownSelect.selectByVisibleText("2 Rooms");
        //SeleniumUtilities1.waitPlease(1000);
       // Actions action = new Actions(driver);
       // action.moveToElement(driver.findElement(By.xpath("//div[@data-autobot-element-id='DASH_TAB_HOTELS_SUBMIT']//button"))).doubleClick().build().perform();
        //SeleniumUtilities1.waitPlease(3);
        //driver.findElement(By.xpath("//td[@style]/div[@class='o_priority o_field_widget']/a[@title='Very High']")).click();
        //driver.findElement(By.xpath("//button[@style='white-space:nowrap;height:56px']")).click();
        WebDriverWait d=new WebDriverWait(driver,10);
        d.until(ExpectedConditions.elementToBeClickable(By.xpath("div[contains(text(),'Search')]")));
        //div[contains(text(),'Search')]
        //driver.findElement(By.xpath("//button[@class='NavigationButton__NavButtonNew-sc-5g7hhu-3 bDCTBx indexesm__Button-sc-1ot0wsx-5 cTYdga']")).click();

        driver.findElement(By.xpath("//button[contains(@class,'sc-hq')]")).click();
        //driver.findElement(By.xpath("div[contains(text(),'Search')]")).submit();
        //driver.findElement(By.xpath("//div[@id='Ezta-dateRangeInput-display-end-inner']")).sendKeys("7/29/2019", Keys.ENTER);
        //driver.findElement(By.xpath("//*[@id=Ezta-submit]/span")).click();
    }
}