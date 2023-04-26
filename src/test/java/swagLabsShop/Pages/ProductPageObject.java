package swagLabsShop.Pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductPageObject extends PageObject {

    public static By productDetailsLinkFor(String productName) {
        return By.linkText(productName);
    }

    public static By productDetailsImageFor(String productName) {
        return By.xpath("//div[@class='inventory_item'][contains(.,'" + productName + "')]//img");
    }

    public String imageTextForProducts(String productsName) {
        return $("//div[@class='inventory_item'][contains(.,'" + productsName + "')]//img").getAttribute("alt");
    }

    public static By productButton() {
        return By.xpath("//div[@class='inventory_details_desc_container']//button");
    }

    public static By backToAllProductsButton() {
        return By.id("back-to-products");
    }

    public static By openProduct(String productName) {
        return By.xpath("//div[@class='inventory_item']//div//div//div[contains(string(), '" + productName + "')]/parent::a");
    }

    public static By getProductNameInDetails() {
        return By.className("inventory_details_name");
    }

    public static By getProductDetailsInDetails() {
        return By.className("inventory_details_desc");
    }

    public static By getProductPriceInDetails() {
        return By.className("inventory_details_price");
    }
}
