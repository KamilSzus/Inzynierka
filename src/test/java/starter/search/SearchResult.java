package starter.search;

import net.serenitybdd.core.steps.UIInteractionSteps;

public class SearchResult extends UIInteractionSteps {
    public String displayed() {
        return find(WikipediaArticle.HEADING).getText();
    }
}