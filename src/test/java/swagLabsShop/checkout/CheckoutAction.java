package swagLabsShop.checkout;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class CheckoutAction extends UIInteractionSteps {

    @Step("User insert name: '{0}'")
    public void insertName(String name){
        find(CheckoutPageObject.firstNameInput()).sendKeys(name);
    }

    @Step("User insert last name: '{0}'")
    public void insertLastName(String lastName){
        find(CheckoutPageObject.lastNameInput()).sendKeys(lastName);
    }

    @Step("User insert name: '{0}'")
    public void insertPostalCode(String postalCode){
        find(CheckoutPageObject.postalCodeInput()).sendKeys(postalCode);
    }

    @Step("User go to overview")
    public void clickContinueButton(){
        find(CheckoutPageObject.continueButton()).click();
    }

    @Step("User finish buying")
    public void clickFinishOverviewButton(){
        find(CheckoutPageObject.finishOverviewButton()).click();
    }

    public String getErrorMessageText() {
        return find(CheckoutPageObject.getErrorMessage()).getText();
    }

    public String getCompleteHeaderText(){
        return find(CheckoutPageObject.getCompleteHeader()).getText();
    }

}
