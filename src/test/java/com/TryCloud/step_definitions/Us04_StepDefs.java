package com.TryCloud.step_definitions;

import com.TryCloud.pages.FilesPage;
import com.TryCloud.pages.HomePage;
import com.TryCloud.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Us04_StepDefs {  // bug

    HomePage homePage = new HomePage();
    FilesPage filesPage = new FilesPage();

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String module) {
        homePage.click(homePage.allModules, module);
    }

    @Then("verify the page title is {string}.")
    public void verifyThePageTitleIs(String expectedTitle) {
        BrowserUtils.verifyTitle(expectedTitle);
    }

    @And("user click the top-left checkbox of the table")
    public void userClickTheTopLeftCheckboxOfTheTable() {
        filesPage.selectAllFilesCheckbox.click();
    }

    @Then("verify all the files are selected")
    public void verifyAllTheFilesAreSelected() {
        for (WebElement each : filesPage.allFilesCheckboxes) {
            Assert.assertTrue(each.isSelected());
        }
    }
}

