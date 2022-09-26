package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PoliciesPage extends BasePage{

    @FindBy(css= ".css-amtdvk")
    public WebElement enableToggle;

    @FindBy(xpath= "//button/b[text()=\"Yes\"]")
    public WebElement yesButton;

    @FindBy(xpath= "//div[@type=\"success\"]")
    public WebElement successMessage;

    @FindBy(xpath = "//input[@type=\"text\"]")
    public WebElement searchInputBox;
}
