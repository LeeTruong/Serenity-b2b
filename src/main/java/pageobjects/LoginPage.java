package pageobjects;
import net.serenitybdd.core.pages.PageObject;

public class LoginPage extends PageObject {
    public static final String USER_NAME_FIELD = "//input[@id='j_username']";
    public static final String PASSWORD_FIELD = "//input[@id='j_password']";
    public static final String SIGN_IN_BUTTON = "//button[@class='button button-block js-prevent-double-click']";
}
