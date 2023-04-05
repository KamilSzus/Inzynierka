package swagLabsShop.product;

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

    public static By productButton(String productName) {
        return By.xpath("//div[@class='inventory_item'][contains(.,'" + productName + "')]//button");
    }

    public static By test(String productName) {
        return By.xpath("//div[@class='inventory_item']//div//div//div[contains(string(), '" + productName + "')]/parent::a");
    }
}
