package com.TryCloud.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    // Methods are static. Because we do not want to create an Object to call those methods. We just want to call those methods with class name. That's why they are static type.

    /**
     * This method is used to pause the code for given seconds
     * It is static method we can call with class name
     * BrowserUtils.sleep(3);
     * @param seconds
     */
    public static void sleep(int seconds){

        try{
            Thread.sleep(seconds*1000);
        } catch(InterruptedException e){
            e.printStackTrace();
            System.out.println("Exception happened in sleep method!");
        }
    }

    //Method info:
    //• Name: verifyTitle()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String expectedTitle
    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
    }

    /**
     * This method will accept dropdown as a WebElement
     * and return all the options' text in a List of String
     * @return List<String>
     */

    public static List<String> dropdownOptiopnsAsString(WebElement dropdown){

        Select select = new Select(dropdown);

        // List of all ACTUAL month<options> as a WebElement
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        // List of all ACTUAL month options as a String
        List<String> actualOptionsAsString = new ArrayList<>();

        // with using for loop we will convert each WebElement of options to String with using getText() method
        // with using add() method we will add each String option in List<String> actual options as String
        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }

       return actualOptionsAsString;
    }


    /**
     * This method will accept a group of radio buttons as a List<WebElement>
     * @param radioButton
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButton, String attributeValue){

        for (WebElement each : radioButton) {
            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                each.click();
            }
        }
    }


    /**
     * Waits for the provided element to be visible on the page
     *
     * @param element
     * @param timeToWaitInSec
     * @return
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }







}
