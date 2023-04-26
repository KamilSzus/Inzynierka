package swagLabsShop.Pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPageObject extends PageObject {

    public String getErrorMessageText() {
        return find(By.cssSelector("h3[data-test='error']")).getText();
    }

    public static By getErrorMessage() {
        return (By.cssSelector("h3[data-test='error']"));
    }

    public static By getPopUpButton() {
        return By.className("error-button");
    }


}
