package swagLabsShop.product;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

public class ProductAction extends UIInteractionSteps {

    @Step("View product details for product '{0}'")
    public void forProductWithName(String productName) {
        $(ProductPageObject.test(productName)).click();
    }

    @Step("View product details for product '{0}' by clicking image")
    public void imageForProductWithName(String productName) {
        $(ProductPageObject.productDetailsImageFor(productName)).click();
    }

    @Step("View product details for product '{0}' by clicking image")
    public void re(String productName) {
        $(ProductPageObject.test(productName)).sendKeys(Keys.ENTER);
    }
}
