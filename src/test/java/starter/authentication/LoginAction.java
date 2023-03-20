package starter.authentication;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class LoginAction extends UIInteractionSteps {

    @Step("Login as {0}")
    public void loginAS(User user){
        $(LoginForm.USERNAME).sendKeys(user.getUserLogin());
        $(LoginForm.PASSWORD).sendKeys(user.getUserPassword());
        $(LoginForm.LOGIN_BUTTON).click();
    }
}