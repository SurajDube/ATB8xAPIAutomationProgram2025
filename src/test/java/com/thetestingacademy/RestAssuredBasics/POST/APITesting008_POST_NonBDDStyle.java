package com.thetestingacademy.RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting008_POST_NonBDDStyle {
    RequestSpecification rs = RestAssured.given();

    @Description("Verify the POST Request : Non BDD style")
    @Test
    public void test_POST_BDDStyle() {
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/auth");
        rs.contentType(ContentType.JSON).log().all();
        rs.body(payload);
        rs.when().post();
        rs.then().log().all().statusCode(200);
    }
}
