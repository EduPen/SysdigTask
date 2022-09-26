package Pages;

import Utilities.BrowserUtils;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    @FindBy(css = "span.title")
    public List<WebElement> menuOptions;

    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(xpath= "//h3")
    public WebElement pageSubTitle;

    @FindBy(xpath = "//a[@id='navbarDropdown']/span")
    public WebElement userName;

    @FindBy(xpath = "//a[.='Log Out']")
    public WebElement logOutLink;

    @FindBy(linkText = "My User")
    public WebElement myUser;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public String getPageSubTitle() {
        waitUntilLoaderScreenDisappear();
        return pageSubTitle.getText();
    }

    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getUserName(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }

    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }

    public void goToMyUser(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(userName, 5).click();
        BrowserUtils.waitForClickablility(myUser, 5).click();

    }

    public void navigateToModule(String tab, String module) {
        String tabLocator = "//div[@class=\"css-1f45x9d\"]/a[@href=\"#/"+tab+"\"]";
        String moduleLocator = "//div[text()='"+ module +"']";

        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 10);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 20);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)), 10);

        }
    }
}
