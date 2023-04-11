package swagLabsShop.checkout;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class CheckoutPageObject extends PageObject {

    public static By firstNameInput(){
        return By.id("first-name");
    }

    public static By lastNameInput(){
        return By.id("last-name");
    }

    public static By postalCodeInput(){
        return By.id("postal-code");
    }

    public static By cancelButton(){
        return By.id("cancel");
    }

    public static By continueButton(){
        return By.id("continue");
    }
}
