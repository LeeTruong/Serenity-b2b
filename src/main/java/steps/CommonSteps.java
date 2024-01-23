package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class CommonSteps extends UIInteractionSteps {

    @Step("Open Cart")
    public void openCart() {
        $(pageobjects.CommonPage.CART_ICON).waitUntilClickable().click();
    }
}
