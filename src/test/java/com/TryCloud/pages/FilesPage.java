package com.TryCloud.pages;

import com.TryCloud.utilities.Driver;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FilesPage extends BasePage{

    @FindBy (id = "app-settings-header")
    public WebElement settings;

    @FindBy (id = "files-setting-richworkspace")
    public WebElement showRichWorkspacesCheckbox;

    @FindBy (xpath = "//label[@for='recommendationsEnabledToggle']")
    public WebElement showRecommendationsCheckbox;

    @FindBy (id = "files-setting-showhidden")
    public WebElement showHiddenFilesCheckbox;

    @FindBy (xpath = "//li[@id='quota']//p")
    public WebElement usage;

    @FindBy (css = "a[class='button new']")
    public WebElement addIconBtn;

    @FindBy (xpath = "//div[@class='newFileMenu popovermenu bubble menu open menu-left']//li")
    public List<WebElement> addIconDropdown;

    @FindBy (xpath = "//input[@type='file']")
    public WebElement inputFile;

    @FindBy (css = "#uploadprogressbar")
    public WebElement loadBar;

    @FindBy (css = "label[for='select_all_files']")
    public WebElement selectAllFilesCheckbox;

    @FindBy (xpath = "(//table[@id='filestable'])[1]//tbody//td[@class='selection']//label")
    public List<WebElement> allFilesCheckboxes;

    @FindBy (id = "view13-input-folder")
    public WebElement inputNewFolderName;

    @FindBy (xpath = "(//input[@type='submit'])[2]")
    public WebElement submitNewFolderIcon;

    @FindBy (xpath = "//div[@id='recommendations']//div[@class='file-name']")
    public List<WebElement> listOfRecentAdd;

    @FindBy (xpath = "(//table[@id='filestable']//tbody//a[@class='action action-menu permanent'])[1]")
    public WebElement firstFileActionBtn;

    @FindBy (xpath = "(//table[@id='filestable'])[1]//tbody//tr[1]//span[@class='innernametext']")
    public WebElement nameOfFirstFile;


//    public void clickAnyActionBtn(int i){
//        String locator = "(//table[@id='filestable']//tbody//a[@class='action action-menu permanent'])[" + i + "]";
//        Driver.getDriver().findElement(By.xpath(locator)).click();
//    }

//    public void getAnyFilesName(int i){
//        String locator = "(//table[@id='filestable']//tbody//a[@class='action action-menu permanent'])[" + i + "]/../preceding-sibling::span[2]";
//        Driver.getDriver().findElement(By.xpath(locator)).getText();
//    }

    @FindBy (xpath = "//div[@class='fileActionsMenu popovermenu bubble open menu']//li")
    public List<WebElement> actionDropdown;

    @FindBy (xpath = "//div[@class='fileActionsMenu popovermenu bubble open menu']//li[8]")
    public WebElement deleteF;

    @FindBy (linkText = "Deleted files")
    public WebElement deletedFiles;

    @FindBy (xpath = "//div[@id = 'app-navigation']//li")
    public List<WebElement> appNavigition;

    @FindBy (xpath = "(//table[@id='filestable'])[12]//tr//td[@class='filename']")
    public List<WebElement> listOfDeletedFiles;

    @FindBy (xpath = "(//span[@class='info'])[2]")
    public WebElement infoInDeletedFiles;

    @FindBy (id = "commentsTabView")
    public WebElement comments;

    @FindBy (css = "div[class='message']")
    public WebElement inputComments;

    @FindBy (xpath = "(//input[@type ='submit'])[2]")
    public WebElement submitComments;

    @FindBy (xpath = "(//ul[@class='comments']//div[@class='message'])[1]")
    public WebElement displayedComment;

    @FindBy (xpath = "(//table[@id='filestable'])[3]//tbody//tr[1]")
    public WebElement firstFavoriteFile;

    @FindBy (xpath = "(//table[@id='filestable'])[3]//tbody//tr")
    public List<WebElement> listOfFavoriteFiles;

    @FindBy (xpath = "(//table[@id='filestable'])[1]//tbody//tr")
    public List<WebElement> listOfAllFiles;


    /**
     *
     * @param element
     * @return
     */
    public int returnNumberFromUsage(WebElement element){

        String[] text = element.getText().split(" ");
        return Integer.valueOf(text[0]);

    }

    /**
     * select one option from list of Elements
     * @param listOfElement
     * @param string
     */
    public void selectFromListOfElements(List<WebElement> listOfElement, String string){
        for (WebElement each: listOfElement){
            if (each.getText().equalsIgnoreCase(string)){
                each.click();
                break;
            }
        }
    }

    /**
     * list of WebElment -> list of String, use getText() method
     * @param listOfElement
     * @return
     */
    public List<String> listOfWebElementToString(List<WebElement> listOfElement){
        List<String> lists = new ArrayList<>();
        for (WebElement each: listOfElement){
            lists.add(each.getText());
        }
        return lists;
    }


    public List<String> nameOfFilesToString(List<WebElement> listOfElement){
        List<String> lists = new ArrayList<>();
        for (WebElement each: listOfElement){
            lists.add(each.getAttribute("data-file"));
        }
        return lists;
    }


}
