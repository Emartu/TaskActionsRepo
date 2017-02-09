package com.epam.page_object.pages;

import com.epam.page_object.base.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class NewMailPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement login;

    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "//a[@data-key='view=toolbar-button-compose-go&id=compose-go']")
    private WebElement createMail;

    @FindBy(xpath = "//div[@data-id='0']")
    private WebElement contextNewPage;

    @FindBy(xpath = "//input[@class='js-search-input js-allow-shortcuts _nb-input-controller']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@data-key='view=folder&fid=6']")
    private WebElement draftLink;


    public NewMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void goToUrl(String URL) {
        Driver.Instance.get(URL);
    }

    public void doLogin(String userName, String passw) {
        login.sendKeys(userName);
        password.sendKeys((passw));
        submit.click();
    }

    public void rightClickOnDraftLink() {
        Actions action = new Actions(driver).contextClick(draftLink);
        action.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ENTER).build().perform();
    }

    public void doJSScroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,150)");
        String sText = js.executeScript("return document.title;").toString();
        System.out.println(sText);
    }

    public void doJSCLick() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (createMail.isEnabled() && createMail.isDisplayed()) {
            System.out.println("Clicking on element with using java script click");
            js.executeScript("arguments[0].click();", createMail);

        }
    }

}
