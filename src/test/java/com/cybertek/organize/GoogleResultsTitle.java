package com.cybertek.organize;
import com.cybertek.utilities.BrowserFactory; // needed to use BrowserFactory we created
import com.cybertek.utilities.SeleniumUtils; // needed to use SeleniumUtils we created
import org.openqa.selenium.By; // needed to use By
import org.openqa.selenium.WebDriver; // needed to use WebDriver
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays; // needed for the List
import java.util.List; // needed for the List
import java.util.concurrent.TimeUnit; // needed to use driver.manage().timeouts().implicitlyWait

public class GoogleResultsTitle {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
    automateGoogleResults("http://google.com");
    etsySearchTest("http://ebay.com");
    vyTrackTitleTest("http://qa2.vytrack.com/user/login");
    //vyTrackShortcut("http://qa2.vytrack.com/user/login");
    }

    public static void openPage(String website){
        //SeleniumUtils.waitPlease(3);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(website);

    }


    public static void vyTrackShortcut(String website) {

        openPage(website);
        WebElement userName = driver.findElement(By.id("prependedInput"));// UserName textbox
        userName.sendKeys("storemanager83");// to enter username
        WebElement passWord = driver.findElement(By.id("prependedInput2")); //password textbox
        passWord.sendKeys("UserUser123"); // to enter password

        WebElement loginButton = driver.findElement(By.id("_submit"));//we found login button
        loginButton.submit(); // it work only with buttons. Click method is more flexible.
        SeleniumUtils.waitPlease(3);


        WebElement label = driver.findElement(By.className("oro-subtitle"));
        String labelName = label.getText();
        SeleniumUtils.verifyEquals("Dashboard", labelName);
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.className("fa-share-square")).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//a[text()='See full list']")).click();

        SeleniumUtils.waitPlease(3);
        driver.findElement(By.linkText("Opportunities")).click();
        SeleniumUtils.waitPlease(3);
        String text = driver.findElement(By.className("oro-subtitle")).getText();
        System.out.println(text);
        SeleniumUtils.verifyEquals("Open Opportunities", text);
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.className("fa-share-square")).click();
//        SeleniumUtils.waitPlease(3);
//        driver.findElement(By.xpath("span[@class='title title-level-1'][contains(text(),'Fleet')]")).click();
//        SeleniumUtils.waitPlease(3);
//        driver.findElement(By.xpath("//span[text()='Vehicle Services Logs']")).click();
//        SeleniumUtils.waitPlease(3);
//        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[8]/a/span")).click();








//        Actions hover = new Actions(driver);
//
//        WebElement Elem_to_hover = driver.findElementBy(By.id("id"));
//
//        hover.moveToElement(Elem_to_hover);
//
//        hover.build();
//
//        hover.perform();
////span[@class='title title-level-1'][contains(text(),'Fleet')]
//
////a[contains(text(),' Fleet')]
//        SeleniumUtils.waitPlease(3);
//        driver.findElement(By.xpath("//span[text()='Vehicle Services Logs']")).click();



//span[@class='Vehicle Services Logs']



//span[@class='title title-level-2'][contains(text(),'Vehicle']
//a[text()='Vehicle Services Logs']
//        WebElement popupMenuElement = driver.findElement(By.className("dropdown-toggle"));
//        popupMenuElement.click();
//        SeleniumUtils.waitPlease(3);
//        driver.findElement(By.linkText("My Configuration")).click();//we found logout button
//        SeleniumUtils.waitPlease(3);
//        WebElement element = driver.findElement(By.className("dropdown-toggle"));
//        String nameOnDropDown = element.getText();
//        System.out.println("Name is :" + nameOnDropDown);
//        if (SeleniumUtils.verifyContains(nameOnDropDown, driver.getTitle()))
//            System.out.println("Name " + nameOnDropDown + " is contained inside web page title : " + driver.getTitle() );
//        else System.out.println("Name " + nameOnDropDown + " is not contained inside web page title: " + driver.getTitle() );
//
//        driver.quit();
    } // automateGoogleResults







    public static void vyTrackTitleTest(String website) {

        openPage(website);
        WebElement userName = driver.findElement(By.id("prependedInput"));// UserName textbox
        userName.sendKeys("user45");// to enter username
        WebElement passWord = driver.findElement(By.id("prependedInput2")); //password textbox
        passWord.sendKeys("UserUser123"); // to enter password

        WebElement loginButton = driver.findElement(By.id("_submit"));//we found login button
        loginButton.submit(); // it work only with buttons. Click method is more flexible.
        SeleniumUtils.waitPlease(3);
        WebElement popupMenuElement = driver.findElement(By.className("dropdown-toggle"));
        popupMenuElement.click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.linkText("My Configuration")).click();//we found logout button
        SeleniumUtils.waitPlease(3);
        WebElement element = driver.findElement(By.className("dropdown-toggle"));
        String nameOnDropDown = element.getText();
        System.out.println("Name is :" + nameOnDropDown);
        if (SeleniumUtils.verifyContains(nameOnDropDown, driver.getTitle()))
            System.out.println("Name " + nameOnDropDown + " is contained inside web page title : " + driver.getTitle() );
        else System.out.println("Name " + nameOnDropDown + " is not contained inside web page title: " + driver.getTitle() );

       // driver.quit();
    } // automateGoogleResults




    public static void etsySearchTest(String website) {

        openPage(website);

        int totalResult;
        int totalResult2;
        String result;
        WebElement inputSearch = driver.findElement(By.id("gh-ac"));
        inputSearch.sendKeys("wooden spoon");
        WebElement buttonSearch = driver.findElement(By.id("gh-btn"));
        buttonSearch.click();
        SeleniumUtils.waitPlease(3);
        WebElement label = driver.findElement(By.className("srp-controls__count-heading"));
        result = label.getText();
        // System.out.println(result);
        result = result.substring(0, result.length()-8).replaceFirst(",","");
        //System.out.println(result);
        totalResult = Integer.parseInt(result.trim());
        // totalResult = Integer.valueOf(result.trim());
        System.out.println("First search # of results : " + totalResult);
        SeleniumUtils.waitPlease(3);
        WebElement link = driver.findElement(By.linkText("All"));
        link.click();
        SeleniumUtils.waitPlease(3);
        label = driver.findElement(By.className("srp-controls__count-heading"));
        result = label.getText();
        //System.out.println(result);
        result = result.substring(0, result.length()-8).replaceFirst(",","");
        //System.out.println(result);
        totalResult2 = Integer.parseInt(result.trim());
        System.out.println("Second search # of results : " + totalResult2);
        System.out.print("Is second search result greater than the first search: ");
        if (totalResult2 > totalResult) System.out.println("PASSED");
        else System.out.println("FAILED");
        driver.navigate().back();
        System.out.print("Does search box have wooden spoon inside: ");
        if (driver.findElement(By.id("gh-ac")).getAttribute("value").equals("wooden spoon")) System.out.println("PASSED");
        else System.out.println("FAILED");
        SeleniumUtils.waitPlease(2);
        driver.navigate().back();
        SeleniumUtils.waitPlease(2);
        System.out.print("Is original ebay web page search box empty: ");
        String inputBoxValue = driver.findElement(By.id("gh-ac")).getAttribute("value");
        System.out.println("The value of search box: " + inputBoxValue);
        if (inputBoxValue.equals("")) System.out.println("PASSED");
        else System.out.println("FAILED");


       // driver.quit();
    } // etsySearchTest






    public static void automateGoogleResults(String website) {
        List<String> searchStrs = Arrays.asList("Java", "JUnit", "REST Assured");
        openPage(website);
        for (int i=0; i < searchStrs.size(); i++) {
            String text1,text2;
            System.out.println(" -------------------------Step--------------------------------------- = " + i);
            System.out.println(searchStrs.get(i));
            WebElement inputSearch = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
            inputSearch.sendKeys(searchStrs.get(i));
            WebElement buttonSearch = driver.findElement(By.xpath("//input[@class='gNO89b']"));
            SeleniumUtils.waitPlease(3);
            buttonSearch.click();
            SeleniumUtils.waitPlease(3);
            WebElement link = driver.findElement(By.xpath("//cite[@class = 'iUh30'][1]"));
            text1 = link.getText();
            System.out.println("Link is : " + text1);
            SeleniumUtils.waitPlease(3);
            link.click();
            SeleniumUtils.waitPlease(3);
            text2 =driver.getCurrentUrl();
            System.out.println("Url is : " + text2);
            System.out.print("Verification of URL and link being the same    :  ");
            SeleniumUtils.verifyEquals(text1, text2);
            driver.navigate().back();
            driver.navigate().back();
            SeleniumUtils.waitPlease(3);
            System.out.println(" -------------------------Step--------------------------------------- = " + i + " is completed ");
        } //for
        //driver.close();
    } // automateGoogleResults






}// GoogleResultsTitle