package swagLabsShop.action;

import net.thucydides.core.annotations.Step;
import swagLabsShop.Pages.SourceDemoHomePage;

public class NavigateTo {

    SourceDemoHomePage sourceHomePage;

    @Step("Open the SourceDemo home page")
    public void theSourceHomePage() {
        sourceHomePage.open();
    }
}