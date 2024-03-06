package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import pageobjects.CartPage;

import java.util.ArrayList;
import java.util.List;

public class CartSteps extends UIInteractionSteps {
    @Steps
    CommonSteps commonSteps;

    @Step("Get list of items in cart")
    public List<String> getListOfItemsInCart() {
        List<WebElementFacade> elements = findAll(CartPage.COLUMN_ITEMS);
        List<String> items = new ArrayList<>();

        for (WebElementFacade element : elements) {
            String attribute = element.getAttribute("value");
            items.add(attribute);
        }
        for (int i = 0; i < items.size(); i++) {
            Serenity.recordReportData().withTitle("Items added to Cart " + (i + 1)).andContents(items.get(i));
        }

        return items;

    }

    @Step("Submit Order")
    public void submitOrder() {
        $(CartPage.SUBMIT_BUTTON).waitUntilClickable().click();
    }

    @Step("Set information in Cart")
    public void setInformationInCart(String poNumber,String dropdown_field,String option_selected) {
        $(CartPage.PO_NUMBER).waitUntilVisible().type(poNumber);
        if (dropdown_field.equals("Will Call")) {
            $(CartPage.WILL_CALL).waitUntilClickable().click();
        }
        $(String.format(CartPage.COMMON_DROP_DOWN,dropdown_field)).selectByVisibleText(option_selected);
//        $(CartPage.WILL_CALL).waitUntilClickable().click();
    }

    @Step("Clear Cart")
    public void clearCart() {
        commonSteps.openCart();
        $(CartPage.CLEAR_CART_BUTTON).waitUntilClickable().click();
        $(CartPage.CONFIRM_CLEAR_CART).waitUntilClickable().click();
    }


}
