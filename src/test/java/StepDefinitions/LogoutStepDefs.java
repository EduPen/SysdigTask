package StepDefinitions;

import Pages.LoginPage;
import Pages.LogoutPage;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutStepDefs {
    LogoutPage logout = new LogoutPage();
    LoginPage login = new LoginPage();

    @When("user logged out")
    public void user_logged_out() {
        logout.userNameClick();
        logout.clickLogout();
        logout.confirmLogout();
    }

    @Then("verify user is on the login page")
    public void verify_user_is_on_the_login_page() {
        Assert.assertTrue(Driver.get().getCurrentUrl().contains("login"));
    }

    @When("user login with valid credentials")
    public void userLoginWithValidCredentials() {
        login.login2();
    }


}
