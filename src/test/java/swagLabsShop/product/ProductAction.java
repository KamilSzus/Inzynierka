package swagLabsShop.product;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

public class ProductAction extends UIInteractionSteps {

    @Step("View product details for product '{0}' by clicking image")
    public void imageForProductWithName(String productName) {
        $(ProductPageObject.productDetailsImageFor(productName)).click();
    }

    @Step("View product details for product '{0}'")
    public void forProductWithName(String productName) {
        $(ProductPageObject.openProduct(productName)).sendKeys(Keys.ENTER);
    }

    @Step("Add product '{0}' to cart from details page")
    public void addProduct(String productName) {
        $(ProductPageObject.productButton()).click();
    }

    @Step("Delete product '{0}' from cart from details page")
    public void deleteProduct(String productName) {
        $(ProductPageObject.productButton()).click();
    }

    @Step("Back to all products")
    public void backToMainMenu(){
        find(ProductPageObject.backToAllProductsButton()).click();
    }

    public String productName() {
        return find(ProductPageObject.getProductNameInDetails()).getText();
    }

    public String productPrice() {
        return find(ProductPageObject.getProductPriceInDetails()).getText();
    }

    public String productDescription() {
        return find(ProductPageObject.getProductDetailsInDetails()).getText();
    }
}
