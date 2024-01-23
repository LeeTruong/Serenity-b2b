package pageobjects;

import net.serenitybdd.core.pages.PageObject;

public class SelectLocationPage extends PageObject {
    public static final String SHIP_TO_LOCATION = "//a[contains(text(),'%s')]";
    public static final String TITLE = "//div[contains(text(),'Select a Location')]";
}
