package org.example.httpbin.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import static org.hamcrest.Matchers.equalTo;


public class APISteps {

    private static final String BASE_URL = "https://httpbin.org";

    @Step("Send GET request to /get endpoint")
    public void getRequest() {
        SerenityRest.given().baseUri(BASE_URL).basePath("/get")
                .when().get()
                .then().statusCode(200)
                .and().body("url", equalTo(BASE_URL + "/get"));
    }

    @Step("Send POST request to /post endpoint with body: {0}")
    public void postRequest(String body) {
        SerenityRest.given().baseUri(BASE_URL).basePath("/post")
                .body(body)
                .when().post()
                .then().statusCode(200)
                .and().body("json.key", equalTo("value"));
    }

    @Step("Send DELETE request to /delete endpoint")
    public void deleteRequest() {
        SerenityRest.given().baseUri(BASE_URL).basePath("/delete")
                .when().delete()
                .then().statusCode(200);
    }

    @Step("Send PATCH request to /patch endpoint with body: {0}")
    public void patchRequest(String body) {
        SerenityRest.given().baseUri(BASE_URL).basePath("/patch")
                .body(body)
                .when().patch()
                .then().statusCode(200)
                .and().body("json.key", equalTo("value"));
    }

    @Step("Send PUT request to /put endpoint with body: {0}")
    public void putRequest(String body) {
        SerenityRest.given().baseUri(BASE_URL).basePath("/put")
                .body(body)
                .when().put()
                .then().statusCode(200)
                .and().body("json.key", equalTo("value"));
    }

    @Step("Send GET request to /basic-auth/{user}/{passwd} endpoint")
    public void basicAuthRequest(String user, String passwd) {
        SerenityRest.given().baseUri(BASE_URL).basePath("/basic-auth/" + user + "/" + passwd)
                .auth().basic(user, passwd)
                .when().get()
                .then().statusCode(200)
                .and().body("authenticated", equalTo(true));
    }

    @Step("Send GET request to /status/{code} endpoint with code: {0}")
    public void statusCodeRequest(int code) {
        SerenityRest.given().baseUri(BASE_URL).basePath("/status/" + code)
                .when().get()
                .then().statusCode(code);
    }

    @Step("Send GET request to /ip endpoint")
    public void ipRequest() {
        SerenityRest.given().baseUri(BASE_URL).basePath("/ip")
                .when().get()
                .then().statusCode(200);
    }

    @Step("Send GET request to /user-agent endpoint")
    public void userAgentRequest() {
        SerenityRest.given().baseUri(BASE_URL).basePath("/user-agent")
                .when().get()
                .then().statusCode(200);
    }

    @Step("Send GET request to /headers endpoint")
    public void headersRequest() {
        SerenityRest.given().baseUri(BASE_URL).basePath("/headers")
                .when().get()
                .then().statusCode(200);
    }

    @Step("Send GET request to /json endpoint")
    public void jsonRequest() {
        SerenityRest.given().baseUri(BASE_URL).basePath("/json")
                .when().get()
                .then().statusCode(200);
    }

    @Step("Send GET request to /cookies endpoint")
    public void cookiesRequest() {
        SerenityRest.given().baseUri(BASE_URL).basePath("/cookies")
                .when().get()
                .then().statusCode(200);
    }

    @Step("Send GET request to /image/png endpoint")
    public void imagePngRequest() {
        SerenityRest.given().baseUri(BASE_URL).basePath("/image/png")
                .when().get()
                .then().statusCode(200);
    }

    @Step("Send GET request to /redirect/{n} endpoint with {0} redirects")
    public void redirectRequest(int n) {
        SerenityRest.given().baseUri(BASE_URL).basePath("/redirect/" + n)
                .when().get()
                .then().statusCode(200);
    }


}
