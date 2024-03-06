package b2btests;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import actions.additemtocart.AddItemToCart;
import assertions.HomePageAssertions;
import assertions.SelectLocationAssertions;
import io.restassured.RestAssured;
import model.CartPageModel;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.rest.SerenityRest;
import org.jsoup.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import steps.CartSteps;
import steps.CommonSteps;
import steps.LoginSteps;
import steps.SelectLocationSteps;
import utils.ApiHelper;
import utils.Utils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestCreateOrder {
    @Steps
    LoginSteps loginSteps;
    SelectLocationSteps selectLocationSteps;
    HomePageAssertions homePageAssertions;
    SelectLocationAssertions selectLocationAssertions;
    AddItemToCart addItemToCart;
    CommonSteps commonSteps;
    ApiHelper apiHelper;
    CartSteps cartSteps;

    String username = "autouser01";
    String password = "Simpson*1234";
    String shipToLocation = "2024307";
    List<String> items = Arrays.asList("A35", "GA1", "LU210", "LU26");
    List<String> qty = Arrays.asList("4", "6", "10" , "12");

    List<String> items2 = Arrays.asList("U14", "TB30");
    List<String> qty2 = Arrays.asList("4", "6");
    String packageType = "Each";





    @Test
    public void B2B41LoginAndCreateOrder() {
        String poNumber = Utils.generateRandomChars(10);


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

        addItemToCart.addMultipleItemsToCart(packageType, items2, qty2);
        commonSteps.openCart();
        List<String> total_list = new ArrayList<>();
        total_list.addAll(items);
        total_list.addAll(items2);
        Serenity.reportThat("Verify items added to cart successfully", () -> {
            List<String> itemsInCart = cartSteps.getListOfItemsInCart();
            System.out.printf("items: %s\n", total_list);
            assert total_list.equals(itemsInCart);
        });

        cartSteps.setInformationInCart(poNumber,"Ship Terms","Will Call (WCL)");

        cartSteps.submitOrder();
    }

    @AfterEach
    public void afterEach() {
        cartSteps.clearCart();
    }





}
