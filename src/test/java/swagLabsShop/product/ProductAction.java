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

    public String productName() {
        return $(".inventory_details_name").getText();
    }

    public String productPrice() {
        return find(ProductPageObject.getProductPriceInDetails()).getText();
    }

    public String productDescription() {
        return find(ProductPageObject.getProductDetailsInDetails()).getText();
    }
}
