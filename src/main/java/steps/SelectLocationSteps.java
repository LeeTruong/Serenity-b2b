package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class SelectLocationSteps extends UIInteractionSteps {

    @Step("Select ship to location {0}")
    public void selectShipToLocation(String shipToLocation) {
        $(String.format(pageobjects.SelectLocationPage.SHIP_TO_LOCATION, shipToLocation)).waitUntilClickable().click();
    }
}
