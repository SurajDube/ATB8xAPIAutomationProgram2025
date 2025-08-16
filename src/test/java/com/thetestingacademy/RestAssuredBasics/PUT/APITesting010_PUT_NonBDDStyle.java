package com.thetestingacademy.RestAssuredBasics.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_PUT_NonBDDStyle {
    RequestSpecification requestSpecification = RestAssured.given();

    @Description("Verify the PUT Request : Non BDD style")
    @Test
    public void test_PUT_BDDStyle() {
       /* {
            "bookingid": 2633,
                "booking": {
            "firstname": "Jim",
                    "lastname": "Brown",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                "checkin": "2018-01-01",
                        "checkout": "2019-01-01"
            },
            "additionalneeds": "Breakfast"
        }
        }

        {
    "token": "14fa5d621fa4259"
}   */
        String payloadPUT = "{\n" +
                "    \"firstname\" : \"sDGmes\",\n" +
                "    \"lastname\" : \"DUrown\",\n" +
                "    \"totalprice\" : 12231,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2021-03-03\",\n" +
                "        \"checkout\" : \"2012-04-05\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        String token = "c829e7d34290f89";
        String bookingID = "168";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        //requestSpecification.auth().preemptive().basic("admin", "password123");
        requestSpecification.body(payloadPUT).log().all();

        Response response = requestSpecification.when().put();

        ValidatableResponse validateResponse = response.then().log().all();
        validateResponse.statusCode(200);

    }
}
