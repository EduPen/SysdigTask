package StepDefinitions;

import Pages.LoginPage;
import Utilities.BrowserUtils;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("Users login with invalid {string} and {string}")
    public void users_login_with_invalid_and(String username, String password) {
        loginPage.login(username, password);
        BrowserUtils.waitFor(3);
    }


    @Then("Error {string} display")
    public void error_display(String message) {
        if(message.equals("Credentials are not valid")){
            Assert.assertEquals(message,loginPage.errorMessage.getText());
        }else if((message.equals("Please fill out this field."))){
            String inputWarning = loginPage.usernameInput.getAttribute("validationMessage");
            if(loginPage.usernameInput.getAttribute("value")==null || loginPage.passwordInput.getAttribute("value")==null)
                Assert.assertEquals(message,inputWarning);
        }
    }

    @When("user login with valid {string} and enter {string}")
    public void userLoginWithValidAndEnter(String email, String password) {
        loginPage.login(email, password);
        BrowserUtils.waitFor(3);
    }

    @Then("verify user logged in the page")
    public void verifyUserLoggedInThePage() {
        String actualTitle = Driver.get().getTitle();
        Assert.assertTrue(actualTitle.contains("Get Started"));
    }
}
