package assertions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class HomePageAssertions extends UIInteractionSteps {

    @Step("Verify Home Page is displayed")
    public void verifyHomePageIsDisplayed() {
        find(pageobjects.HomePage.HOME_PAGE).isDisplayed();
    }
}
