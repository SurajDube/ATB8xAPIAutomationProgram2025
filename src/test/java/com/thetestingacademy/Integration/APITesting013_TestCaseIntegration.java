package com.thetestingacademy.Integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting013_TestCaseIntegration {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    String bookingID;
//    {
//        "token": "36a9b42e65c51b2"
//    }

    public String getToken() {
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON).log().all();
        requestSpecification.body(payload);

        response = requestSpecification.when().post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        token = response.jsonPath().getString("token");
        System.out.println(token);
        return token;
    }

    public String getBookingID() {
        String payloadPOST = "{\n" +
                "    \"firstname\" : \"Gmes\",\n" +
                "    \"lastname\" : \"rown\",\n" +
                "    \"totalprice\" : 11231,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2020-03-03\",\n" +
                "        \"checkout\" : \"2019-04-05\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
        requestSpecification = RestAssured.given().given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.given().contentType(ContentType.JSON);
        requestSpecification.body(payloadPOST).log().all();
        response = requestSpecification.when().post();
        ValidatableResponse validateResponse = response.then().log().all();
        validateResponse.statusCode(200);
        bookingID = response.jsonPath().getString("bookingid");
        System.out.println(bookingID);
        return bookingID;
    }

    @Test (priority = 1)
    public void test_update_request_PUT() {
        String token = getToken();
        System.out.println(token);
        String bookingId = getBookingID();
        System.out.println(bookingId);
        String payloadPUT = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"rownrown\",\n" +
                "    \"totalprice\" : 1231,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-09-03\",\n" +
                "        \"checkout\" : \"2020-09-05\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        //requestSpecification.auth().preemptive().basic("admin", "password123");
        requestSpecification.body(payloadPUT).log().all();

        response = requestSpecification.when().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println(bookingID);
        System.out.println(token);
    }

    @Test(priority = 2)
    public void test_update_request_get() {
        System.out.println(bookingID);
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingID);
        response = requestSpecification.when().log().all().get();
        requestSpecification.then().log().all().statusCode(200);

        String firstname = response.jsonPath().getString("firstname");
        Assert.assertEquals(firstname, "James");
    }

    @Test(priority = 3)
    public void test_delete_booking() {
        System.out.println(bookingID);
        System.out.println(token);
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingID);
        response = requestSpecification.when().log().all().delete();
        requestSpecification.then().log().all().statusCode(201);
    }
    @Test(priority = 4)
    public void test_after_delete_request_get() {
        System.out.println(bookingID);
        System.out.println(token);
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingID);
        response = requestSpecification.when().log().all().get();
        requestSpecification.then().log().all().statusCode(200);
    }
}
