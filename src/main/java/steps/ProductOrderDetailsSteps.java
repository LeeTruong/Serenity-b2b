package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import pageobjects.ProductOrderDetailsPage;

public class ProductOrderDetailsSteps extends UIInteractionSteps {
    @Step("Add item {0} to cart")
    public void addItemToCart(String packageType) {
        $(String.format(pageobjects.ProductOrderDetailsPage.ADD_TO_CART_BUTTON_BY_TYPE, packageType)).waitUntilClickable().click();
    }

    @Step("Enter quantity {1} for package type {0}")
    public void enterQuantity(String packageType,String quantity) {
        $(String.format(ProductOrderDetailsPage.QTY_INPUT, packageType)).waitUntilVisible().clear();

        $(String.format(ProductOrderDetailsPage.QTY_INPUT, packageType)).waitUntilVisible().sendKeys(quantity);
    }
}
