package com.TryCloud.step_definitions;

import com.TryCloud.pages.BasePage;
import com.TryCloud.pages.FilesPage;
import com.TryCloud.pages.HomePage;
import com.TryCloud.pages.LoginPage;
import com.TryCloud.utilities.BrowserUtils;
import com.TryCloud.utilities.ConfigurationReader;
import com.TryCloud.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Us10_StepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    FilesPage filesPage = new FilesPage();
    Faker faker = new Faker();
    int initialUsage = 0;

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage.login(ConfigurationReader.getProperty("username2"), ConfigurationReader.getProperty("password"));
    }

    @When("user clicks the {string} module")
    public void user_clicks_the_module(String module) {
        homePage.click(homePage.allModules, module);
    }

    @When("user clicks Settings on the left bottom corner")
    public void user_clicks_settings_on_the_left_bottom_corner() {
        filesPage.settings.click();
    }

    @Then("user should be able to click any buttons")
    public void user_should_be_able_to_click_any_buttons() {
        List<WebElement> checkboxes = new ArrayList<>(Arrays.asList(filesPage.showRichWorkspacesCheckbox,filesPage.showRecommendationsCheckbox, filesPage.showHiddenFilesCheckbox));
        for (WebElement each: checkboxes){
            Assert.assertTrue(each.isEnabled());
        }
    }

    @When("user checks the current storage usage")
    public void user_checks_the_current_storage_usage() {
        initialUsage = filesPage.returnNumberFromUsage(filesPage.usage);
    }

    @When("user uploads file with the upload file option")
    public void user_uploads_file_with_the_upload_file_option() {
        BrowserUtils.sleep(2);
        filesPage.addIconBtn.click();
        BrowserUtils.sleep(2);
        filesPage.selectFromListOfElements(filesPage.addIconDropdown, "Upload file");
        BrowserUtils.sleep(2);
        filesPage.inputFile.sendKeys("/Users/dil/Downloads/apple.png");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(filesPage.loadBar));
    }

    @When("user refresh the page")
    public void user_refresh_the_page() {
        Driver.getDriver().navigate().refresh();
    }

    @Then("user should be able to see storage usage is increased")
    public void user_should_be_able_to_see_storage_usage_is_increased() {
        int updatedUsage = filesPage.returnNumberFromUsage(filesPage.usage);
        Assert.assertTrue(updatedUsage > initialUsage);
    }

}