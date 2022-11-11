package com.TryCloud.step_definitions;

import com.TryCloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;

public class Us12_StepDefs {  // bug

    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String expectedTitle) {
        BrowserUtils.verifyTitle(expectedTitle);
    }

}
