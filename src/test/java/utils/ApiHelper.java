package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.rest.SerenityRest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiHelper extends UIInteractionSteps {

    public class Result {
        public String csrfToken;
        public String sessionID;

        public Result(String csrfToken, String sessionID) {
            this.csrfToken = csrfToken;
            this.sessionID = sessionID;
        }
    }


    @Step("Get CSRF Token")
    public Result getCsrfToken() {
        String login_url = "https://s3-customer.strongtie.com/onlineordering/login";
        String security_url = "https://s3-customer.strongtie.com/onlineordering/j_spring_security_check";
        String get_location_url = "https://s3-customer.strongtie.com/onlineordering/getsoldtoshipto";
        String set_location_url = "https://s3-customer.strongtie.com/onlineordering/setsoldtoshipto?soldToId=1015188&shipToId=2047089";

        Response response_1 = SerenityRest.given()
                .when()
                .get(login_url);

        String sessionID = response_1.getSessionId();
        String responseString = response_1.getBody().asString();
        String regex = "CSRFToken.=.'(.+[a-zA-Z0-9])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(responseString);

        if (!matcher.find()) {
            throw new RuntimeException("CSRF Token not found");
        }

        String csrfToken_1 = matcher.group(1);

        Response response_2 = SerenityRest.given()
                .sessionId(sessionID)
                .contentType(ContentType.URLENC)
                .formParams("j_username", "autouser01", "j_password", "Simpson*1234", "CSRFToken", csrfToken_1)
                .when()
                .post(security_url);

        String sessionID_2 = response_2.getSessionId();

        Response response_4 = SerenityRest.given().contentType(ContentType.TEXT).when()
                .sessionId(sessionID_2)
                .get(get_location_url);

        System.out.printf("Response: %s\n", response_4.getBody().asString());

        Response response_3 = SerenityRest.given()
                .sessionId(sessionID_2)
                .get(set_location_url);

        String responseString_3 = response_3.getBody().asString();
        Matcher matcher_3 = pattern.matcher(responseString_3);

//        Response response_4 = SerenityRest.given()
//                .sessionId(sessionID_2)
//                .contentType(ContentType.TEXT)
//                .queryParam("soldToId", "1015188")
//                .queryParam("shipToId", "2047089")
//                .when()
//                .get(set_location_url);

        if (!matcher_3.find()) {
            throw new RuntimeException("CSRF Token not found");
        } else {
            return new Result(matcher_3.group(1), sessionID_2);
        }
    }

    @Step("Clear Cart")
    public void clearCart() {
        ApiHelper.Result result = getCsrfToken();
        String csrfToken = result.csrfToken;
        String sessionID = result.sessionID;

        String cart_url = "https://s3-customer.strongtie.com/onlineordering/cart";
        String clear_cart_url = "https://s3-customer.strongtie.com/onlineordering/cart/clear-cart";
        String cart_details_url = "https://s3-customer.strongtie.com/onlineordering/cartDetails/getEntryDetailsForCart";
        String update_cart_url = "https://s3-customer.strongtie.com/onlineordering/cart/saveShippingCarrier";

        Response response_1 = SerenityRest.given()
                .sessionId(sessionID)
                .contentType(ContentType.TEXT)
                .when()
                .get(cart_details_url);

        Response response_2 = SerenityRest.given()
                .sessionId(sessionID)
                .contentType(ContentType.TEXT)
                .formParam("CSRFToken", csrfToken)
                .when()
                .get(update_cart_url);

        Response response = SerenityRest.given()
                .sessionId(sessionID)
                .contentType(ContentType.TEXT)
                .when()
                .get(cart_url);

//        System.out.printf("Response: %s\n", response.getBody().asString());
    }


}
