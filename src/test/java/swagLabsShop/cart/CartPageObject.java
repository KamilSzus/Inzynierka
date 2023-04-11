package swagLabsShop.cart;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

public class CartPageObject extends PageObject {

    private static final By CART_ITEM = By.cssSelector(".cart_item");

    public List<CartItem> items() {
        return findAll(CART_ITEM).map(
                item -> new CartItem(
                        item.findBy(".inventory_item_name").getText(),
                        item.findBy(".inventory_item_desc").getText(),
                        priceForm(item.findBy(".inventory_item_price").getText())
                )
        );
    }

    public static By continueShopping(){
        return By.id("continue-shopping");
    }

    public static By checkout(){
        return By.name("checkout");
    }

    private Double priceForm(String textValue) {
        return Double.parseDouble(textValue.replace("$", ""));
    }
}

