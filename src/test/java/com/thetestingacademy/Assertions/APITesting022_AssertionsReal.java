package com.thetestingacademy.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

import static org.assertj.core.api.Assertions.*;

public class APITesting022_AssertionsReal {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validateResponse;
    String token;
    Integer bookingId;

    @Test
    public void test_post() {
        String payload_post = "{\n" +
                "    \"firstname\" : \"robert\",\n" +
                "    \"lastname\" : \"gayle\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_post).log().all();

        Response response = requestSpecification.when().post();

        //perform validation
        validateResponse = response.then().log().all();
        validateResponse.statusCode(200);

        // 3 things for assertion
        // 1. validateResponse
        // 2. testNG Assertion
        // 3. AssertJ Assertion
        validateResponse.body("booking.firstname", Matchers.equalTo("robert"));

        // how to extract booking id
        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("bookingid.firstname");
        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname, "robert");


        //using AssertJ
        assertThat(bookingId).isNotNull().isPositive().isNotZero();
        assertThat(firstname).isEqualTo("robert").isNotNull().isNotBlank().isNotEmpty();

    }
}
