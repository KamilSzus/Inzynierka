package swagLabsShop.action;

import net.serenitybdd.core.pages.PageObject;

public class InventoryAction extends PageObject {

    public String getHeading() {
        return $(".title").getText();
    }
}