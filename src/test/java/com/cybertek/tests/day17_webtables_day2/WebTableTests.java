package com.cybertek.tests.day17_webtables_day2;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class WebTableTests extends TestBase {
    /*
    Write a method that will return count of rows
     */

    public int getCountOfRows(){
        return driver.findElements(By.cssSelector("#table1 tr")).size();
    }

    public int getCountOfRows(By by){
        return driver.findElements(by).size();
    }

    @Test
    public void countOfRowsTest1(){
        Assert.assertEquals(getCountOfRows(),5, "Number of rows doesn't match");
        System.out.println("******************** Finished **********************8");
    }

    @Test
    public void countOfRowsTest2(){
        Assert.assertEquals(getCountOfRows(By.xpath("//table[1]//tr")),5, "Number of rows doesn't match");
        System.out.println("******************** Finished **********************8");
    }

    /*
    Write a method that returns number of columns
     */
    public int getCountOfColumns(){
        return driver.findElements(By.cssSelector("#table1 th")).size();
    }

    public int getCountOfColumns(By x){
        return driver.findElements(x).size();
    }

    @Test
    public void countOfColumnsTest1(){
        Assert.assertEquals(getCountOfColumns(), 6, "Number of columns do not match");
    }

    @Test
    public void countOfColumnsTest2(){
        Assert.assertEquals(getCountOfColumns(By.xpath("//table[1]//th")), 6, "Number of columns do not match");
    }

    /*
    Let's write a method that will return table size
    first value - number of rows
    second value - number of columns
     */

    public int[] getTableSize(){
        int[] size = { getCountOfRows(),getCountOfColumns()};
        return size;
    }

    public int[] getTableSize(By rowLocator, By columnLocator){
        int[] size = { getCountOfRows(rowLocator),getCountOfColumns(columnLocator)};
        return size;
    }

    @Test
    public void tableSizeTest1(){
        int[] expectedSize = {5,6};
        int [] actualSize = getTableSize();
        Assert.assertEquals(actualSize, expectedSize, "Table size does not match");
    }

    @Test
    public void tableSizeTest2(){
        int[] expectedSize = {5,6};
        int [] actualSize = getTableSize(By.xpath("//table[1]//tr"), By.xpath("//table[1]//th"));
        Assert.assertEquals(actualSize, expectedSize, "Table size does not match");
    }


    /*
    Let's write a method that will return table headers (column names) as a list of Web Elements
     */
    public List<WebElement> getHeaders() {
        return driver.findElements(By.cssSelector("#table1 th"));
    }

    /*
    This method returns table headers (column names) text as a List of Strings
     */
    public List<String> getHeadersText(){
        List<String> headers = new ArrayList<>();
        for (WebElement tableHeader : getHeaders()){
            headers.add(tableHeader.getText());
        }
        return headers;
    }

    @Test
    public void getHeadersTest(){
        List <String> expectedColumnNames = Arrays.asList("Last Name", "First Name" , "Email", "Due", "Web Site", "Action");
        Assert.assertEquals(getHeadersText(), expectedColumnNames, "headers names do not match");
    }

    //Lets write a test
    //to verify if first name column is sorted in alphabetical order
    @Test
    public void sortColumnTest(){
        String columnName = "First Name";
        driver.findElement(By.xpath("//table[1]//th//span[text()='First Name']")).click();
        List<String> sorted = new ArrayList<>();
        sorted.addAll(getColumnData(columnName));
        Collections.sort(sorted);
        Assert.assertEquals(getColumnData(columnName), sorted);
    }


    public List<String> getColumnData( String columnName){
        int columnNumber=0;
       // WebElement elements = driver.findElements(By.xpath("//table[1]//tbody//tr//td[2]"));
        for (int i= 0; i < getCountOfColumns(); i++){
            if (columnName.equals(getHeadersText().get(i))){
                columnNumber = i+1;
            }
        }//for

        String locatorForColumn = "//table[1]//tbody//tr/td[" + columnNumber + "]";
        List<WebElement> columnCollectionOfWebElements = driver.findElements(By.xpath(locatorForColumn));
        List<String> columnCollectionOfText = new ArrayList<>();

        for (WebElement element : columnCollectionOfWebElements){
            columnCollectionOfText.add(element.getText());
        }
        //System.out.println(columnCollectionOfText);
        return columnCollectionOfText;

    }


    @Test
    public void getValueFromTable(){
        System.out.println(driver.findElements(By.cssSelector("#table1 tbody tr2 td3")));
    }

}
