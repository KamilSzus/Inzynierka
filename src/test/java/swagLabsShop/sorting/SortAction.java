package swagLabsShop.sorting;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class SortAction extends UIInteractionSteps {

    @Step("User chose to sort product by '{0}'")
    public void selectSortingBy(String sortingType){
        find(SortPageObject.getSortingDropdown()).selectByVisibleText(sortingType);
    }

    @Step("User click on dropdown list")
    public void clickOnDropdown(){
        find(SortPageObject.getSortingDropdown()).click();
    }
}
