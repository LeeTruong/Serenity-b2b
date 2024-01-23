package pageobjects;

import net.serenitybdd.core.steps.UIInteractionSteps;

public class ProductOrderDetailsPage extends UIInteractionSteps {
    public static final String FLY_OUT_SCREEN = "//div[@id='custom-panel']//h1[text()='%s']";
    public static final String ADD_TO_CART_BUTTON_BY_TYPE = "//table[contains(@class,'order-options')]//div[contains(text(),'%s')]" +
            "/../../following-sibling::td/button[contains(@class,'cart')]";
    public static final String QTY_INPUT = "//table[contains(@class,'order-options')]//div[contains(text(),'%s')]" +
            "/../../following-sibling::td/input";
}
