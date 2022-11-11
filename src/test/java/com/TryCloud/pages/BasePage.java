package com.TryCloud.pages;

import com.TryCloud.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//ul[@id = 'appmenu']//a")
    public List<WebElement> allModules;


    /**
     * This is for click one module from list of modules.
     * @param listOfModules
     * @param nameOfModule
     */
    public void click(List<WebElement> listOfModules, String nameOfModule){
        for (WebElement each: allModules){
            if (each.getAttribute("aria-label").equals(nameOfModule)){
                each.click();
                break;
            }
        }
    }


}
