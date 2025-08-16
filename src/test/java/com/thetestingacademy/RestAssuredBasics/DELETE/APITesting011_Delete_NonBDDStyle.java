package com.thetestingacademy.RestAssuredBasics.DELETE;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_Delete_NonBDDStyle {
    RequestSpecification requestSpecification = RestAssured.given();

    @Description("Verify the DELETE Request : Non BDD style")
    @Test
    public void test_Delete_BDDStyle() {
        String token = "ea3fb2ca7d9120c";
        String bookingID = "168";
        //GIVEN PART
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingID);
        requestSpecification.contentType(ContentType.JSON);
        //requestSpecification.cookie("token", token);
        requestSpecification.auth().preemptive().basic("admin", "password123");

        //WHEN PART
        Response response = requestSpecification.when().delete();

        //THEN PART
        ValidatableResponse validateResponse = response.then().log().all();
        validateResponse.statusCode(201);
    }
}
