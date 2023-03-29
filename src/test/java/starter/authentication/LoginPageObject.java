package starter.authentication;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPageObject extends PageObject {
    public String getErrorMessage(){
        return find(By.cssSelector("h3[data-test='error']")).getText();
    }
}
