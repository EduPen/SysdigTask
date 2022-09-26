package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{

    @FindBy (xpath = "//div/button/b[text()=\"Logout\"]")
    public WebElement logoutConfirm;

    @FindBy (xpath = "//li/button/b[text()=\"Logout\"]")
    public WebElement logoutButton;

    @FindBy (css = ".css-1j7crcp")
    public WebElement userNameButton;

    public void userNameClick () { userNameButton.click();
    }

    public void clickLogout () {
        logoutButton.click();
    }

    public void confirmLogout () {
        logoutConfirm.click();
    }



}
