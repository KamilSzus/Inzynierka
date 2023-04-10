package swagLabsShop.cart;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ShoppingCartIcon extends PageObject {


    public static By findCart() {
        return By.id("shopping_cart_container");
    }
}