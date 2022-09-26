package StepDefinitions;

import Pages.PoliciesPage;
import Utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class PoliciesStepDef {
    PoliciesPage policiesPage = new PoliciesPage();

    @And("user navigate to {string} module to {string}")
    public void userNavigateToModuleTo(String tab, String module) {
        policiesPage.navigateToModule(tab, module);
    }


    @And("user search a {string}")
    public void userSearchA(String policyName) {
        policiesPage.searchInputBox.click();
        policiesPage.searchInputBox.sendKeys(policyName);
    }

    @And("user enable to selected policy")
    public void userEnableToSelected() {
        policiesPage.enableToggle.click();
        policiesPage.yesButton.click();
    }

    @Then("verify that searched {string} is enabled")
    public void verifyThatSearchedIsEnabled(String policyName) {
        Assert.assertEquals("success", policiesPage.successMessage.getAttribute("type"));
    }
}
