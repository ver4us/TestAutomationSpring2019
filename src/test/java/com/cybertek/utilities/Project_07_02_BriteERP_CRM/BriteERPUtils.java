package com.cybertek.utilities.Project_07_02_BriteERP_CRM;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BriteERPUtils {

    public static void takeAscreenShot(String event){

        try {
            //Here I am taking the screenshot
            TakesScreenshot file = (TakesScreenshot) Driver.getDriver();
            File source = file.getScreenshotAs(OutputType.FILE);
            //Here I want to store it
            String timeString = LocalDateTime.now().format(DateTimeFormatter.ofPattern(" yyyy_MM_dd_h_mm_ss"));
            FileUtils.copyFile(source, new File("/Users/Kursat/IdeaProjects/" +
                    "TestAutomationSpring2019/src/test/java/com/cybertek/Brite_ERP/" +
                    "Project_07_02_BriteERP_CRM/Screenshots/" + event + "_"+ timeString +".jpg"));
        } catch ( IOException e){
            System.out.println("System was not able to take a screenhot");
        }
    }







}
