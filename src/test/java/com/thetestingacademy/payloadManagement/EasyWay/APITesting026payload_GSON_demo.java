package com.thetestingacademy.payloadManagement.EasyWay;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class APITesting026payload_GSON_demo {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;

    @Test
    public void testPositive() {
        Booking booking = new Booking();
        booking.setFirstname("suraj");
        booking.setLastname("dubey");
        booking.setTotalprice(524);
        booking.setDepositpaid(false);

        Bookingdates bookingDates = new Bookingdates();
        bookingDates.setCheckin("2019-03-03");
        bookingDates.setCheckout("2020-03-03");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Lunch");

        System.out.println(booking);

        // booking is an object
        // Gson to json Serialization
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);    // Gson to json format (in json format)
        System.out.println(jsonStringBooking);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        //requestSpecification.auth().preemptive().basic("admin", "password123");
        requestSpecification.body(jsonStringBooking).log().all();

        // json to string
        response = requestSpecification.when().post();
        String jsonResponseString = response.asString();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        // how to verify 1. extract() 2. jsonpath().getString() : response is small

        // when response is complex need to convert String to object
// DeSerialization (json to object)
        BookingResponse bookingResponse = gson.fromJson(jsonResponseString, BookingResponse.class);
        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("suraj").isNotNull().isNotEmpty();



    }
}