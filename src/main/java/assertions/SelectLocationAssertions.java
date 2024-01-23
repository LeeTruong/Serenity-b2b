package assertions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class SelectLocationAssertions extends UIInteractionSteps {

    @Step("Verify title is {0}")
    public void verifyTitle() {
        find(pageobjects.SelectLocationPage.TITLE).isDisplayed();
    }
}
