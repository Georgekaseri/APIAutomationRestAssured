package org.example.Misc.gSon;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PostReqTC {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    @Test
    public void testPositive(){

        // Step1 - POST
        // URL -> Base URI + base Path
        // HEADER
        // BODY
        // Auth - NO


        // Step 2
        // prepare the Payload ( Object -> JSON String)
        // send the request

        //Step 3
        // Validate Response ( JSON String -> Object)
        // FirstName,
        // Status Code
        // Time Response

        // Prepare your Payload
        Faker faker = new Faker();
        Booking booking = new Booking();
        String expectFirstName = faker.name().firstName();
        String expectLastName = faker.name().lastName();

        booking.setFirstname(expectFirstName);
        booking.setLastname(expectLastName);
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-03-01");
        bookingdates.setCheckout("2024-03-25");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");



        // Object -> JSON String (GSON)
        Gson gson = new Gson();
        String jsonStringBooking =  gson.toJson(booking);




        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        Response response = requestSpecification.when().post();
        String jsonResponseString  = response.asString();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        // Validate Response ( JSON String -> Object)
        BookingResponse bookingResponseObject = gson.fromJson(jsonResponseString,BookingResponse.class);

        assertThat(bookingResponseObject.getBookingid()).isNotNull();
        assertThat(bookingResponseObject.getBooking().getFirstname()).isEqualTo(expectFirstName);
        assertThat(bookingResponseObject.getBooking().getLastname()).isEqualTo(expectLastName);



    }
}
