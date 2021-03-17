package com.testing.steps.serenity;


import com.testing.classess.Facebook;
import com.testing.classess.Login;
import net.thucydides.core.annotations.Step;

public class EndUserSteps {
    Login login;
    Facebook facebook;

    @Step
    public void user_open_google_homepage() throws InterruptedException {
        login.user_open_google_homepage();

    }
    @Step
    public void user_Search_for(String arg1) throws InterruptedException {
        login.user_Search_for(arg1);

    }

   @Step
    public void user_is_on_login_page() throws InterruptedException {
        facebook.user_is_on_login_page();
    }

    @Step
    public void user_enter_username_and_password(String arg1, String arg2) throws InterruptedException {
        facebook.user_enter_username_and_password(arg1, arg2);
    }

    @Step
    public void user_enter_email_as(String arg1) throws InterruptedException {
        facebook.user_enter_email_as(arg1);
    }

    @Step
    public void user_open_in_new_tab(String arg1) throws InterruptedException {
        facebook.user_open_in_new_tab(arg1);

    }

}
