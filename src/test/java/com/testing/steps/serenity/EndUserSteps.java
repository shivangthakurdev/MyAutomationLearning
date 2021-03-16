package com.testing.steps.serenity;


import com.testing.classess.Login;
import net.thucydides.core.annotations.Step;

public class EndUserSteps {
    Login login;

    @Step
    public void user_open_google_homepage() throws InterruptedException {
        login.user_open_google_homepage();

    }
    @Step
    public void user_Search_for(String arg1) throws InterruptedException {
        login.user_Search_for(arg1);

    }
}
