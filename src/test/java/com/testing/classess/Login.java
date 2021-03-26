package com.testing.classess;

import com.testing.Pages.ExtendedPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


public class Login extends ExtendedPageObject {


    public void closetheBrowser(){
        getDriver().close();
    }

    public void user_open_google_homepage() throws InterruptedException {
        waitForPageLoaded();
        getDriver().get("https://www.google.com/");
        getDriver().manage().window().maximize();

    }
    @FindBy (name = "q")
    WebElementFacade search;
    public void user_Search_for(String arg1) throws InterruptedException {
        waitForPageLoaded();
        withTimeoutOf(15, TimeUnit.SECONDS).waitForPresenceOf(By.name("q"));
        search.sendKeys(arg1);

    }
}
