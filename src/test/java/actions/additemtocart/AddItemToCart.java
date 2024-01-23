package actions.additemtocart;

import assertions.HomePageAssertions;
import assertions.ProductOrderDetailsAssertions;
import assertions.SelectLocationAssertions;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import steps.HomePageSteps;
import steps.LoginSteps;
import steps.ProductOrderDetailsSteps;
import steps.SelectLocationSteps;

import java.util.Arrays;
import java.util.List;

public class AddItemToCart extends UIInteractionSteps {

    @Steps
    HomePageSteps homePageSteps;
    ProductOrderDetailsSteps productOrderDetailsSteps;

    @Step("Add multiple items to cart")
    public void addMultipleItemsToCart(String packageType, List<String> items, List<String> qty) {
        for (int i = 0; i < items.size(); i++) {
            String item = items.get(i);
            String quantity = qty.get(i);
            homePageSteps.searchFor(item);
            homePageSteps.selectSuggestionItem(item);
            productOrderDetailsSteps.addItemToCart(packageType);
            productOrderDetailsSteps.enterQuantity(packageType, quantity);
            homePageSteps.openHomePage();

        }
    }
}
