package swagLabsShop.action;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import swagLabsShop.Pages.CartPageObject;
import swagLabsShop.Pages.ShoppingCartIcon;
import swagLabsShop.Pages.ProductList;

import java.util.List;

public class CartAction extends UIInteractionSteps {
    @Step("Open the shopping Cart")
    public void openCart() {
        $(ShoppingCartIcon.findCart()).click();
    }

    @Step("Add product '{0}' to cart")
    public void addItem(String productName) {
        $(ProductList.productButton(productName)).click();
    }

    @Step("Delete product '{0}' to cart")
    public void deleteItem(String productName) {
        $(ProductList.productButton(productName)).click();
    }

    @Step("Add product '{0}' to cart")
    public void addItems(List<String> productNamesList) {
        productNamesList.forEach(this::addItem);
    }

    @Step("Back to shopping")
    public void backShopping() {
        find(CartPageObject.continueShopping()).click();
    }

    @Step("Go to checkout")
    public void goToCheckout() {
        find(CartPageObject.checkout()).click();
    }

    public String checkNumberOfProductsInCartIcon() {
        return $("//*[@class='shopping_cart_container']/a/span").getAttribute("innerHTML");
    }

    public String checkIfCartContains(String productName) {
        return $("//div[@class = 'cart_list']//a[contains(.,'" + productName + "')]").getText();
    }
}
