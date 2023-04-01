package swagLabsShop.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.AssertionsForClassTypes;
import swagLabsShop.authentication.LoginAction;
import swagLabsShop.authentication.LoginPageObject;
import swagLabsShop.authentication.User;
import swagLabsShop.inventory.InventoryAction;
import swagLabsShop.navigation.NavigateTo;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefinitions {

    @Steps
    NavigateTo navigateTo;
    @Steps
    LoginAction loginAction;
    @Steps
    InventoryAction inventoryAction;
    @Steps
    LoginPageObject loginPageObject;

    @Given("^(?:.*) is researching things on the internet")
    public void i_am_on_the_Wikipedia_home_page() {
        navigateTo.theHomePage();
    }

    @Given("User open the shop page")
    public void i_am_on_the_shop_page() {
        navigateTo.theSourceHomePage();
    }

    @When("User insert correct credential and try login")
    public void i_am_sucesfully_login_to_the_page_shop() {
        loginAction.loginAS(User.STANDARD_USER);
    }

    @When("User insert incorrect {string} and try login")
    public void i_am_see_error_message_on_login_page(String data) {
        User user;

        switch (data) {
            case "username" -> user = User.INCORRECT_USERNAME_USER;
            case "password" -> user = User.INCORRECT_PASSWORD_USER;
            default -> user = User.INCORRECT_USER;
        }

        loginAction.loginAS(user);
    }

    @Then("User should see main page")
    public void i_am_sucesfully() {
        Serenity.reportThat("Check if heading is equal to \"Products\" ", () ->
                AssertionsForClassTypes.assertThat(inventoryAction.getHeading()).isEqualToIgnoringCase("Products"));
    }

    @Then("User see error message on login page that contains this message {string}")
    public void i_am_see_error(String errorMessage) {
        Serenity.reportThat("Check if error message is equal to \"" + errorMessage + "\" ", () ->
                AssertionsForClassTypes.assertThat(loginPageObject.getErrorMessageText()).isEqualToIgnoringCase(errorMessage));
    }

    @When("Clicks login button")
    public void clicksLoginButton() {
        loginAction.clickLoginButton();
    }

    @When("User insert {string}")
    public void userInsert(String action) {
        if (action.equals("password")) {
            loginAction.insertPassword(User.STANDARD_USER);
        } else if (action.equals("username")) {
            loginAction.insertUsername(User.STANDARD_USER);
        }
    }

    @When("User insert incorrect credential")
    public void userInsertIncorrectCredential() {
        loginAction.loginAS(User.INCORRECT_USER);
    }

    @When("Get error message")
    public void getErrorMessage() {
        assertThat(LoginPageObject.getErrorMessage()).isNotNull();
    }

    @When("Try close this message")
    public void tryCloseThisMessage() {
        loginAction.closeErrorMessage();
    }

    @Then("Error message should disappear")
    public void errorMessageShouldDisappear() {
        assertThat(loginAction.isErrorMessageDisplayed()).isFalse();
    }

    @Given("User is login on the main page")
    public void userIsLoginOnTheMainPage() {
        loginAction.loginAS(User.STANDARD_USER);
        Serenity.reportThat("Check if heading is equal to \"Products\" ", () ->
                AssertionsForClassTypes.assertThat(inventoryAction.getHeading()).isEqualToIgnoringCase("Products"));
    }

    @Given("Click on hamburger menu")
    public void clickOnHamburgerMenu() {
    }

    @Then("Click on logout")
    public void clickOnLogout() {
    }

    @When("Refresh browser")
    public void refreshBrowser() {
    }
}

