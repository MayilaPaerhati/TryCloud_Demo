package com.TryCloud.step_definitions;

import com.TryCloud.pages.HomePage;
import com.TryCloud.pages.LoginPage;
import com.TryCloud.utilities.ConfigurationReader;
import com.TryCloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;

public class Us03_StepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @When("the users  log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage.login(ConfigurationReader.getProperty("username1"),ConfigurationReader.getProperty("password"));
    }

    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> expectedModules) {
        List<String> actualModules = new ArrayList<>();
        for (WebElement each: homePage.allModules){
            actualModules.add(each.getAttribute("aria-label"));
        }
        Assert.assertTrue(actualModules.containsAll(expectedModules));
    }

}
