package com.testing.steps;

import com.testing.steps.serenity.EndUserSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class DefinitionSteps {
    @Steps
    EndUserSteps steps;

    @Given("^user open google homepage$")
    public void user_open_google_homepage() throws InterruptedException {
       steps.user_open_google_homepage();
    }

    @Then("^user Search for \"([^\"]*)\"$")
    public void user_Search_for(String arg1) throws InterruptedException {
        steps.user_Search_for(arg1);

    }

}
