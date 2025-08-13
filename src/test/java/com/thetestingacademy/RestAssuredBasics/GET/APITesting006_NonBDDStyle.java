package com.thetestingacademy.RestAssuredBasics.GET;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting006_NonBDDStyle {
    // non bdd style is more scalable and maintainable and used in real time
    static RequestSpecification rs = RestAssured.given();

    @Description("Test case 1 : test_NonBDDStyle_Positive")
    @Test
    public void test_NonBDDStyle_Positive() {

        rs.baseUri("https://www.zippopotam.us/");
        rs.basePath("IN/284001");

        rs.when().log().all().get();
        rs.then().log().all().statusCode(200);
    }

    @Test
    @Description("Test case 2 : test_NonBDDStyle_Negative")
    public void test_NonBDDStyle_Negative() {
        rs.baseUri("https://www.zippopotam.us/");
        rs.basePath("IN/284002");

        rs.when().log().all().get();
        rs.then().log().all().statusCode(404);
    }
}

