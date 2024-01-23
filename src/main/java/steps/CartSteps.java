package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import pageobjects.CartPage;

import java.util.ArrayList;
import java.util.List;

public class CartSteps extends UIInteractionSteps {
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

}
