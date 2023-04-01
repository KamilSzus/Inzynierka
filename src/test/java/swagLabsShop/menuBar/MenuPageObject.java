package swagLabsShop.menuBar;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class MenuPageObject extends PageObject {
    public By getHamburgerMenu() {
        return find(By.id("react-burger-menu-btn"));
    }

    public By getCloseMenuButton() {
        return find(By.id("react-burger-cross-btn"));
    }
}
