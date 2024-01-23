package pageobjects;

import net.serenitybdd.core.pages.PageObject;

public class CartPage extends PageObject {
    public static final String COLUMN_ITEMS = "//table[@id='cart-table-rows']//tbody//tr//td[contains" +
            "(@class,'cart-item-number')]//input";
}
