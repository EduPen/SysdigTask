package Pages;


import Utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@name=\"username\"]")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@name=\"password\"]")
    public WebElement passwordInput;

    @FindBy(tagName = "button")
    public WebElement loginBtn;

    ////button[@type="submit"]

    @FindBy(xpath = "//div[@data-test='error-message']")
    public WebElement errorMessage;



    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void login2() {
        usernameInput.sendKeys(ConfigurationReader.get("userName"));
        passwordInput.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();
    }


}