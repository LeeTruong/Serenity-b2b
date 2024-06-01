package org.example.httpbin.features.api;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.example.httpbin.steps.APISteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class APITests {

    @Steps
    APISteps apiSteps;

    @Test
    public void testGetRequest() {
        apiSteps.getRequest();
    }

    @Test
    public void testPostRequest() {
        apiSteps.postRequest("{\"key\": \"value\"}");
    }

    @Test
    public void testDeleteRequest() {
        apiSteps.deleteRequest();
    }

    @Test
    public void testPatchRequest() {
        apiSteps.patchRequest("{\"key\": \"value\"}");
    }

    @Test
    public void testPutRequest() {
        apiSteps.putRequest("{\"key\": \"value\"}");
    }

    @Test
    public void testBasicAuthRequest() {
        apiSteps.basicAuthRequest("user", "passwd");
    }

    @Test
    public void testStatusCodeRequest() {
        apiSteps.statusCodeRequest(200);
        apiSteps.statusCodeRequest(500);
    }

    @Test
    public void testIpRequest() {
        apiSteps.ipRequest();
    }

    @Test
    public void testUserAgentRequest() {
        apiSteps.userAgentRequest();
    }

    @Test
    public void testHeadersRequest() {
        apiSteps.headersRequest();
    }

    @Test
    public void testJsonRequest() {
        apiSteps.jsonRequest();
    }

    @Test
    public void testCookiesRequest() {
        apiSteps.cookiesRequest();
    }

    @Test
    public void testImagePngRequest() {
        apiSteps.imagePngRequest();
    }

    @Test
    public void testRedirectRequest() {
        apiSteps.redirectRequest(1);
        apiSteps.redirectRequest(2);
    }
}
