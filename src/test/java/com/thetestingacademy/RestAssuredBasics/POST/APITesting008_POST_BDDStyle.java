package com.thetestingacademy.RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITesting008_POST_BDDStyle {
    @Description("Verify the POST Request : BDD style")
    @Test
    public void test_POST_BDDStyle() {
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/auth")
                    .contentType(ContentType.JSON)
                    .log().all()
                    .body(payload)
                .when()
                    .log().all()
                    .post()
                .then()
                    .log().all()
                    .statusCode(200);
    }
}
