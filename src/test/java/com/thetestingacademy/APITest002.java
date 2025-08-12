package com.thetestingacademy;

import io.restassured.RestAssured;

public class APITest002 {
    public static void main(String[] args) {
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking/1")
                .when()
                    .get()
                .then()
                    .log().all()
                    .statusCode(200);
    }
}
