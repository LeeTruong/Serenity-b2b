package pageobjects;

import net.serenitybdd.core.pages.PageObject;

public class CartPage extends PageObject {
    public static final String COLUMN_ITEMS = "//table[@id='cart-table-rows']//tbody//tr//td[contains" +
            "(@class,'cart-item-number')]//input";
    public static final String CLEAR_CART_BUTTON = "//button[text()='Clear Cart']";
    public static final String CONFIRM_CLEAR_CART = "//button[contains(@class,'cart-confirmation-confirm-button')]";
    public static final String PO_NUMBER = "//input[@id='po-number']";
    public static final String COMMON_DROP_DOWN = "//label[normalize-space(text())='%s:']/following-sibling::" +
            "select[not(contains(@class, 'hidden'))]";
    public static final String WILL_CALL = "//input[@id='will-call-check']";

    public static final String SUBMIT_BUTTON = "//div[contains(@class,'cart-header-summary')]//button[contains(@class,'submit-order')]";
}
