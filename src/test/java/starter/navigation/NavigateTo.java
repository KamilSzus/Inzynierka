package starter.navigation;

import net.thucydides.core.annotations.Step;

public class NavigateTo {

    WikipediaHomePage homePage;
    SourceDemoHomePage sourceHomePage;

    @Step("Open the Wikipedia home page")
    public void theHomePage() {
        homePage.open();
    }


    @Step("Open the SourceDemo home page")
    public void theSourceHomePage() {
        sourceHomePage.open();
    }
}