package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class HomePageSteps extends UIInteractionSteps {

    @Step("Open Home Page")
    public void openHomePage() {
        openUrl("https://s3-customer.strongtie.com/onlineordering/");
    }

    @Step("Search for {0}")
    public void searchFor(String searchItem) {
        $(pageobjects.HomePage.SEARCH_BOX).sendKeys(searchItem);
    }

    @Step("Select suggestion item {0}")
    public void selectSuggestionItem(String suggestionItem) {
        $(String.format(pageobjects.HomePage.SUGGESTION_ITEM, suggestionItem)).waitUntilClickable().click();
    }


}
