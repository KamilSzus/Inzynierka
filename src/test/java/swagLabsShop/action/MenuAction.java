package swagLabsShop.action;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import swagLabsShop.Pages.MenuPageObject;

public class MenuAction extends UIInteractionSteps {

    @Step("User open menu bar")
    public void openMenu(){
        $(MenuPageObject.getHamburgerMenu()).click();
    }

    @Step("Click on {0} in menu")
    public void clickOn(String buttonName){
        $(MenuPageObject.clickOnButtonInMenu(buttonName)).click();
    }
}
