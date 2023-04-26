package swagLabsShop.Pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class SortPageObject extends PageObject {

    public static By getSortingDropdown() {
        return By.className("product_sort_container");
    }

}
