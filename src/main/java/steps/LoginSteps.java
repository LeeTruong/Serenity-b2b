package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import pageobjects.LoginPage;

public class LoginSteps extends UIInteractionSteps {

    @Step("Open login page")
    public void openLoginPage() {
        openUrl("https://s3-customer.strongtie.com/onlineordering/login");
    }

    @Step("Enter username")
    public void enterUsername(String username) {
        $(LoginPage.USER_NAME_FIELD).type(username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        $(LoginPage.PASSWORD_FIELD).type(password);
    }

    @Step("Click sign in button")
    public void clickSignInButton() {
        $(LoginPage.SIGN_IN_BUTTON).click();
    }

    @Step("Login with username {0} and password {1}")
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSignInButton();
    }
}
