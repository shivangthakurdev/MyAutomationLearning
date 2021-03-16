package com.testing.Pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExtendedPageObject extends PageObject {

    static Logger log = LoggerFactory.getLogger(ExtendedPageObject.class);

    public void waitForPageLoaded() throws InterruptedException {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        Thread.sleep(1999);
        System.out.println("Waiting for Page Load");

    }

    public String getURL() throws InterruptedException {
        waitForPageLoaded();
        Thread.sleep(2999);
        return getDriver().getCurrentUrl();
    }

    private WebElement findTheVisibleOne(By locator) {
        List<WebElement> allFound = this.getDriver().findElements(locator);
        log.info("Method: findTheVisibleOne() - Total found: " + allFound.size());
        WebElement visibleOne = null;
        for (WebElement webElement : allFound) {
            if (webElement.isDisplayed()) {
                log.info("visible one found: " + webElement.toString());
                visibleOne = webElement;
                break;
            }
        }
        return visibleOne;
    }

    public WebElement returnTheVisibleOne(By locator) throws InterruptedException {
        waitForPageLoaded();
        WebElement theVisibleOne = findTheVisibleOne(locator);
        if (theVisibleOne == null) {
            //try again after 2 second
            log.info("Trying again after 2 sec...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
//				System.err.println("Thread is interrupted when sleeping!!!");
                log.error("Thread is interrupted when sleeping!!!\n" + ex.toString(), ex);
            }
            theVisibleOne = findTheVisibleOne(locator);
            if (theVisibleOne == null)
                throw new InterruptedException("No visible element found");
        }
        log.info("Returning the visible one");
        return theVisibleOne;
    }

    public void refreshBrowser() {
        getDriver().navigate().refresh();
    }

    public void sendValueByPlaceHolder(String placeHolder,String value)throws InterruptedException{
        waitForPageLoaded();
        String xpathExpression = "(//input[@placeholder='" + placeHolder + "'])";
        int xpathCount = getDriver().findElements(By.xpath(xpathExpression)).size();
        System.out.println("number of field found "+xpathCount);
        if(xpathCount>1){
            String xpathExpression1 = "(//input[@placeholder='" + placeHolder + "'])[2]";
            returnTheVisibleOne(By.xpath(xpathExpression1)).sendKeys(value);
            Thread.sleep(2000);
        }
        else {
            returnTheVisibleOne(By.xpath(xpathExpression)).sendKeys(value);
            Thread.sleep(2000);
        }
    }
    public void sendValueByPlaceHolder1(String placeHolder,String value)throws InterruptedException{
        waitForPageLoaded();
        String xpathExpression = "(//input[@placeholder='" + placeHolder + "'])";
        int xpathCount = getDriver().findElements(By.xpath(xpathExpression)).size();
        System.out.println("number of field found "+xpathCount);
        if(xpathCount>1){
            String xpathExpression1 = "(//input[@placeholder='" + placeHolder + "'])[1]";
            returnTheVisibleOne(By.xpath(xpathExpression1)).sendKeys(value);
            Thread.sleep(2000);
        }
        else {
            returnTheVisibleOne(By.xpath(xpathExpression)).sendKeys(value);
            Thread.sleep(2000);
        }
    }
    public void clickOnGivenDropDown(String opt) throws InterruptedException{
        waitForPageLoaded();
        int len=getDriver().findElements(By.className("ui-dropdown-item")).size();
        /*if(len>1){
            String name;
            for(int i=0;i<len;i++){
                name=getDriver().findElements(By.className("ui-dropdown-item")).get(i).getText();
                System.out.println("text is: "+name);
                if(name.equalsIgnoreCase(opt)){
                    getDriver().findElements(By.className("ui-dropdown-item")).get(i).click();
                    System.out.println("text is with in loop: "+name);
                    Thread.sleep(999);
                    break;
                }
            }
        }
        else{
            System.out.println("drop down option not available");
        }*/
        String xpathExpression="//p-dropdown//li//span[text()='"+opt+"']";
        withTimeoutOf(20, TimeUnit.SECONDS).waitForPresenceOf(net.serenitybdd.core.annotations.findby.By.xpath(xpathExpression));
        getDriver().findElement(By.xpath(xpathExpression)).click();
        Thread.sleep(1999);

    }
}
