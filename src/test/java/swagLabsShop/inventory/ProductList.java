package swagLabsShop.inventory;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import swagLabsShop.cart.CartItem;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductList extends PageObject {

    public List<String> getListOfProductsNameOnPage() {
        return findAll(".inventory_item_name").textContents();
    }

    public List<String> getListOfProductsDescriptionOnPage() {
        return findAll(".inventory_item_desc").textContents();
    }

    public List<String> getListOfProductsPriceOnPage() {
        return findAll(".inventory_item_price").textContents();
    }

    public List<CartItem> getListOfAllProductsObject() {
        List<String> productsName = getListOfProductsNameOnPage();
        List<String> productsDescription = getListOfProductsDescriptionOnPage();
        List<String> productsPrice = getListOfProductsPriceOnPage();

        return IntStream.range(0, productsName.size())
                .mapToObj(i -> new CartItem(
                        productsName.get(i),
                        productsDescription.get(i),
                        Double.parseDouble(productsPrice.get(i).replace("$",""))
                ))
                .collect(Collectors.toList());
    }

    public static By productDetailsLinkFor(String productName) {
        return By.linkText(productName);
    }

    public String imageTextForProducts(String productsName) {
        return $("//div[@class='inventory_item'][contains(.,'" + productsName + "')]//img").getAttribute("alt");
    }

    public static By productButton(String productName) {
        return By.xpath("//div[@class='inventory_item'][contains(.,'" + productName + "')]//button");
    }

    public String checkIfCartContains(String productName) {
        return $("//div[@class = 'cart_list']//a[contains(.,'" + productName + "')]").getText();
    }

    public String getProductDescriptionMainPage(String product){
        return find(By.xpath("//div[@class='inventory_item'][contains(.,'" + product + "')]//div[@class='inventory_item_desc']")).getText();
    }

    public String getProductNameMainPage(String product){
        return find(By.xpath("//div[@class='inventory_item'][contains(.,'" + product + "')]//div[@class='inventory_item_name']")).getText();
    }

    public String getProductPriceMainPage(String product){
        return find(By.xpath("//div[@class='inventory_item'][contains(.,'" + product + "')]//div[@class='inventory_item_price']")).getText();
    }

}