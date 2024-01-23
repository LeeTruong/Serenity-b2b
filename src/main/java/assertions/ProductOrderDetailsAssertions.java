package assertions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class ProductOrderDetailsAssertions extends UIInteractionSteps {

    @Step("Verify fly out screen of item {0} is displayed")
    public void verifyFlyOutScreenIsDisplayed(String item) {
        find(String.format(pageobjects.ProductOrderDetailsPage.FLY_OUT_SCREEN, item)).waitUntilVisible().isDisplayed();
    }


}
