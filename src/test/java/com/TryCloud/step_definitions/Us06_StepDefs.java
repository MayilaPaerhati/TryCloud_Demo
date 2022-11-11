package com.TryCloud.step_definitions;

import com.TryCloud.pages.FilesPage;
import com.TryCloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Us06_StepDefs {

    FilesPage filesPage = new FilesPage();
    String nameOfFile = filesPage.nameOfFirstFile.getText();

    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {
        Assert.assertFalse(filesPage.nameOfFilesToString(filesPage.listOfFavoriteFiles).equals(nameOfFile));
    }

    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
         filesPage.addIconBtn.click();
    }

    @When("users uploads file with the {string} option")
    public void users_uploads_file_with_the_upload_file_option(String optionFromAddBtn) {
        filesPage.selectFromListOfElements(filesPage.addIconDropdown, optionFromAddBtn);
        filesPage.inputFile.sendKeys("/Users/dil/Downloads/pasta picture.jpeg");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(filesPage.loadBar));
    }

    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        List<String> namesOfAllFiles = filesPage.nameOfFilesToString(filesPage.listOfAllFiles);
        Assert.assertTrue(namesOfAllFiles.contains(nameOfFile));

    }

}
