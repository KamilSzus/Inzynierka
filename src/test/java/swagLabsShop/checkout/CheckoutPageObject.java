package swagLabsShop.checkout;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class CheckoutPageObject extends PageObject {

    public static By firstNameInput() {
        return By.id("first-name");
    }

    public static By lastNameInput() {
        return By.id("last-name");
    }

    public static By postalCodeInput() {
        return By.id("postal-code");
    }

    public static By cancelButton() {
        return By.id("cancel");
    }

    public static By continueButton() {
        return By.id("continue");
    }

    public static By cancelOverviewButton() {
        return By.id("cancel");
    }

    public static By finishOverviewButton() {
        return By.id("finish");
    }

    public static By getErrorMessage() {
        return (By.cssSelector("h3[data-test='error']"));
    }

    public static By getCompleteHeader(){
        return By.className("complete-header");
    }

    public static By getCompleteBody(){
        return By.className("complete-text");
    }
}
