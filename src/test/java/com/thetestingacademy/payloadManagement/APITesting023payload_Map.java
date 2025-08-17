package com.thetestingacademy.payloadManagement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting023payload_Map {

    @Test
    public void testPostReq() {
        RequestSpecification requestSpecification;
        ValidatableResponse validatableResponse;
        Response response;
/*
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
*/

        Map<String, Object> jsonbodyUsingHashMap = new LinkedHashMap();
        jsonbodyUsingHashMap.put("firstname", "Gmes");
        jsonbodyUsingHashMap.put("lastname", "rown");
        jsonbodyUsingHashMap.put("totalprice", 1234);
        jsonbodyUsingHashMap.put("depositpaid", true);

        Map<String, Object> bookingDatesMap = new LinkedHashMap();
        bookingDatesMap.put("checkin", "2019-03-03");
        bookingDatesMap.put("checkout", "2021-03-03");

        jsonbodyUsingHashMap.put("bookingdates", bookingDatesMap);
        jsonbodyUsingHashMap.put("additionalneeds", "Lunch");

        System.out.println(jsonbodyUsingHashMap);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);

        //requestSpecification.auth().preemptive().basic("admin", "password123");
        requestSpecification.body(jsonbodyUsingHashMap).log().all();

        response = requestSpecification.when().post();

        Integer bookingId = response.then().extract().path("bookingid");

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("your bookingId is : " + bookingId);
    }
}