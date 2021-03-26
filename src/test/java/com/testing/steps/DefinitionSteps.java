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

    @Given("^user is on login page$")
    public void user_is_on_login_page() throws InterruptedException {
       steps.user_is_on_login_page();
    }

    @Then("^user enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_enter_username_and_password(String arg1, String arg2) throws InterruptedException {
        steps.user_enter_username_and_password(arg1, arg2);
    }

    @Then("^user open \"([^\"]*)\" in new tab$")
    public void user_open_in_new_tab(String arg1) throws InterruptedException {
        steps.user_open_in_new_tab(arg1);
    }

    @Then("^user enter email as \"([^\"]*)\"$")
    public void user_enter_email_as(String arg1) throws InterruptedException {
        steps.user_enter_email_as(arg1);

    }

}
