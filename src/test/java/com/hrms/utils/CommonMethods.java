package com.hrms.utils;

import com.hrms.testbase.BaseClass;
import com.hrms.testbase.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonMethods extends PageInitializer {
    /*This method will clear a textbox and send text to it*/
    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);

    }

    /**
     * this method will return an object of Explicit wait
     * /**
     *
     * @return
     */
    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    /*Theis methods wil wait until given element becomes clickable*/

    /**
     * @param element
     */
    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));

    }

    /*Theis methods wil wait until and then click */

    /**
     * @param element
     */
    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public static void JSclick(WebElement element) {
        getJSExecutor().executeScript("argumetns[0].click();", element);

    }

    /**
     * @param fileName
     */
    public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] bytes=ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCRENSHOT_FILEPATH + fileName + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * @param pattern
     * @return
     */
    public static String getTimeStamp(String pattern) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return (sdf.format(date));

    }
}



