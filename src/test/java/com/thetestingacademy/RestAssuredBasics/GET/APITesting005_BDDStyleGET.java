package com.thetestingacademy.RestAssuredBasics.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting005_BDDStyleGET {
    @Test
    public void test_GET_MethodPositive() {
        String pincode_positive = "284001";
        RestAssured
                .given()
                    .baseUri("https://www.zippopotam.us/")
                    .basePath("IN/" + pincode_positive)
                .when()
                    .log().all().get()
                .then()
                    .log().all().statusCode(200);

    }

    @Test
    public void test_GET_MethodNegative() {
        String pincode_Negative = "-284003";
        RestAssured
                .given()
                    .baseUri("https://www.zippopotam.us/")
                    .basePath("IN/" + pincode_Negative)
                .when()
                    .log().all().get()
                .then()
                    .log().all().statusCode(400);

    }


}
