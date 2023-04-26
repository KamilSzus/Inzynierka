package swagLabsShop.Pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class MenuPageObject extends PageObject {

    public static By getHamburgerMenu() {
        return By.id("react-burger-menu-btn");
    }

    public static By getCloseMenuButton() {
        return By.id("react-burger-cross-btn");
    }

    public static By clickOnButtonInMenu(String buttonName) {
        return By.id(buttonName + "_sidebar_link");
    }

}
