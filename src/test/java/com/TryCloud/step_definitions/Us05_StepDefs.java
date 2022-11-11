package com.TryCloud.step_definitions;

import com.TryCloud.pages.FilesPage;
import com.TryCloud.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import javax.sql.rowset.BaseRowSet;
import java.util.List;

public class Us05_StepDefs {

    FilesPage filesPage = new FilesPage();
    Faker faker = new Faker();
    String nameOfAddedFavoriteFile = "";

    @When("the user clicks action-icon  from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {
           filesPage.firstFileActionBtn.click();
           nameOfAddedFavoriteFile = filesPage.nameOfFirstFile.getText();
    }

    @When("user choose the {string} option")
    public void user_choose_the_option(String string) {
        filesPage.selectFromListOfElements(filesPage.actionDropdown,string);
    }

    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String string) {
        filesPage.selectFromListOfElements(filesPage.appNavigition,string);
    }

    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        Assert.assertEquals(nameOfAddedFavoriteFile,filesPage.firstFavoriteFile.getAttribute("data-file"));
    }
}
