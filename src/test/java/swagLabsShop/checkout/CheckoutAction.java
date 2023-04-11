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

}
