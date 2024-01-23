package b2btests;

import actions.additemtocart.AddItemToCart;
import assertions.HomePageAssertions;
import assertions.SelectLocationAssertions;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import steps.CartSteps;
import steps.CommonSteps;
import steps.LoginSteps;
import steps.SelectLocationSteps;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestCreateOrder {
    @Steps
    LoginSteps loginSteps;
    SelectLocationSteps selectLocationSteps;
    HomePageAssertions homePageAssertions;
    SelectLocationAssertions selectLocationAssertions;
    AddItemToCart addItemToCart;
    CommonSteps commonSteps;

    CartSteps cartSteps;

    String username = "autouser01";
    String password = "Simpson*1234";
    String shipToLocation = "2024307";
    List<String> items = Arrays.asList("A35", "GA1", "LU210");
    List<String> qty = Arrays.asList("4", "6", "10");
    String packageType = "Each";

    @Test
    public void B2B41LoginAndCreateOrder() {

        loginSteps.openLoginPage();

        loginSteps.login(username, password);

        Serenity.reportThat("Verify title is 'Select Location'", () -> {
            selectLocationAssertions.verifyTitle();
        });

        selectLocationSteps.selectShipToLocation(shipToLocation);

        Serenity.reportThat("Verify Home Page is displayed", () -> {
            homePageAssertions.verifyHomePageIsDisplayed();
        });

        addItemToCart.addMultipleItemsToCart(packageType, items, qty);

        commonSteps.openCart();
        Serenity.reportThat("Verify items added to cart successfully", () -> {
            List<String> itemsInCart = cartSteps.getListOfItemsInCart();
            assert items.equals(itemsInCart);
        });

    }


}
