package com.TryCloud.step_definitions;

import com.TryCloud.pages.FilesPage;
import com.TryCloud.utilities.BrowserUtils;
import com.TryCloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Us07_StepDefs {

    FilesPage filesPage = new FilesPage();
    String nameForNewFolder = "Hello World";

    @When("user clicks the add icon on the top")
    public void user_clicks_the_add_icon_on_the_top() {
        filesPage.addIconBtn.click();
    }

    @And("user click {string}")
    public void userClick(String string) {
        filesPage.selectFromListOfElements(filesPage.addIconDropdown,string);
    }

    @When("user write a folder name")
    public void user_write_a_folder_name() {
        filesPage.inputNewFolderName.sendKeys(nameForNewFolder);
    }

    @When("the user click submit icon")
    public void the_user_click_submit_icon() {
        filesPage.submitNewFolderIcon.click();
    }

    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {
        BrowserUtils.sleep(1);
        List<String> listOfFileNameAsString = filesPage.nameOfFilesToString(filesPage.listOfAllFiles);
        Assert.assertTrue(listOfFileNameAsString.contains(nameForNewFolder));
    }

    @And("user choose a folder from the page")
    public void userChooseAFolderFromThePage() {
        BrowserUtils.sleep(2);
        filesPage.firstFileInTheAllFilesList.click();
    }

    @When("the user uploads a file with the upload file option")
    public void theUserUploadsAFileWithTheUploadFileOption() {
        filesPage.addIconBtn.click();
        filesPage.inputFile.sendKeys("/Users/dil/Downloads/apple.png");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(filesPage.loadBar));
    }

    @Then("Verify the file is displayed on the page")
    public void verifyTheFileIsDisplayedOnThePage() {
        List<String> namesOfFilesFromSelectedFolder = filesPage.nameOfFilesToString(filesPage.filesInSelectedFolder);
        Assert.assertTrue(namesOfFilesFromSelectedFolder.contains("apple.png"));

    }
}
