package com.testing.classess;

import com.testing.Pages.ExtendedPageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;


public class Facebook extends ExtendedPageObject {

    public void user_is_on_login_page() throws InterruptedException {
        waitForPageLoaded();
        waitForPageLoaded();
        getDriver().get("https://www.facebook.com/");
        getDriver().manage().window().maximize();


    }

    @FindBy (id = "email")
    WebElementFacade emailField;
    @FindBy (id = "pass")
    WebElementFacade passwordField;
    public void user_enter_username_and_password(String arg1, String arg2) throws InterruptedException {
        waitForPageLoaded();
        withTimeoutOf(15, TimeUnit.SECONDS).waitForPresenceOf(By.id("email"));
        emailField.sendKeys(arg1);
        withTimeoutOf(15,TimeUnit.SECONDS).waitForPresenceOf(By.id("passContainer"));
        passwordField.sendKeys(arg2);
        Thread.sleep(2999);

    }

    @FindBy (id = "login")
    WebElementFacade loginmail;
    @FindBy (xpath = "//input[contains(@type,'submit')]")
    WebElementFacade checkInbox;
    public void user_enter_email_as(String arg1) throws InterruptedException {
        waitForPageLoaded();
        withTimeoutOf(15,TimeUnit.SECONDS).waitForPresenceOf(By.id("login"));
        loginmail.sendKeys(arg1);
        withTimeoutOf(15,TimeUnit.SECONDS).waitForPresenceOf(By.xpath("//input[contains(@type,'submit')]"));
        checkInbox.click();
        Thread.sleep(3000);
    }

    public void user_open_in_new_tab(String arg1) throws InterruptedException {
        waitForPageLoaded();
        JavascriptExecutor js=(JavascriptExecutor) getDriver();
        js.executeScript("window.open('"+arg1+"', '_blank');");
//        getDriver().get(arg1);

        getDriver().manage().window().maximize();

    }
}
