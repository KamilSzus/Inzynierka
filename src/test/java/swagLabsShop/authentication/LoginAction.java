package swagLabsShop.authentication;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class LoginAction extends UIInteractionSteps {

    @Step("Login as {0}")
    public void loginAS(User user) {
        $(LoginForm.USERNAME).sendKeys(user.getUserLogin());
        $(LoginForm.PASSWORD).sendKeys(user.getUserPassword());
        $(LoginForm.LOGIN_BUTTON).click();
    }

    @Step("Click login button")
    public void clickLoginButton() {
        $(LoginForm.LOGIN_BUTTON).click();
    }

    @Step("Close error pop up")
    public void closeErrorMessage() {
        find(LoginPageObject.getPopUpButton()).click();
    }

    public void insertPassword(User user) {
        $(LoginForm.PASSWORD).sendKeys(user.getUserPassword());
    }

    public void insertUsername(User user) {
        $(LoginForm.USERNAME).sendKeys(user.getUserLogin());
    }

    public boolean isErrorMessageDisplayed() {
        return $(LoginPageObject.getErrorMessage()) == null;
    }
}