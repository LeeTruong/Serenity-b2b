package pageobjects;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.ResolvableElement;

public class HomePage extends PageObject{
    public static final String HOME_PAGE = "//body[contains(@class,'page-homepage')]";
    public static final String ITEMS_MENU_BAR = "//a[@title='%s']";
    public static final String OPTION_IN_ITEM_MENU_BAR = "//a[@title='%s']";
    public static final String SEARCH_BOX = "//input[@id='js-site-search-input']";
    public static final String SUGGESTION_ITEM = "//li[@class='autoSuggestion-wrapper']//div[text()='%s']/parent::a";
}
