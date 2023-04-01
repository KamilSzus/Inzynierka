package swagLabsShop.navigation;

import net.thucydides.core.annotations.Step;

public class NavigateTo {

    SourceDemoHomePage sourceHomePage;

    @Step("Open the SourceDemo home page")
    public void theSourceHomePage() {
        sourceHomePage.open();
    }
}