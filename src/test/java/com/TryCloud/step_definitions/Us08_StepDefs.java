package com.TryCloud.step_definitions;

import com.TryCloud.pages.FilesPage;
import com.TryCloud.utilities.BrowserUtils;
import com.TryCloud.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Us08_StepDefs {

    FilesPage filesPage = new FilesPage();
    String nameOfFirstFile = filesPage.nameOfFirstFile.getText();

    @When("user click action-icon  from any file on the page")
    public void user_click_action_icon_from_any_file_on_the_page() {
        filesPage.firstFileActionBtn.click();
    }

    @And("user choose the Delete f option")
    public void userChooseTheDeleteFOption() {
        filesPage.deleteF.click();
    }


    @When("the user clicks the Deleted files sub-module on the left side")
    public void the_user_clicks_the_sub_module_on_the_left_side() {
        filesPage.deletedFiles.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(filesPage.loadBar));
    }


    @Then("Verify the deleted file is displayed on the page.")
    public void verify_the_deleted_file_is_displayed_on_the_page() {

        List<String> nameOfDeletedFilesAsString = filesPage.listOfWebElementToString(filesPage.nameOfDeletedFiles);

        Assert.assertTrue(nameOfDeletedFilesAsString.contains(nameOfFirstFile));

    }

}
