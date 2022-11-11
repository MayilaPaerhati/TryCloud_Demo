package com.TryCloud.step_definitions;

import com.TryCloud.pages.FilesPage;
import com.TryCloud.utilities.BrowserUtils;
import com.TryCloud.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import javax.sql.rowset.BaseRowSet;
import java.util.List;

public class Us09_StepDefs {

    FilesPage filesPage = new FilesPage();

    @When("user write a comment inside the input box")
    public void user_write_a_comment_inside_the_input_box() {
        filesPage.comments.click();
    }

    @When("user click the submit button to post it")
    public void user_click_the_submit_button_to_post_it() {
        filesPage.inputComments.sendKeys("Great Job");
        filesPage.submitComments.click();
    }

    @Then("Verify the comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section() {
        BrowserUtils.sleep(2);
        String actual = filesPage.displayedComment.getText();
        Assert.assertEquals("Great Job",actual);
    }

}
