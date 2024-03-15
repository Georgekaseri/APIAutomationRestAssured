package org.example.Misc.payloadMap;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class payloadUsingMap {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    /*
    String payload = "{\n" +
                "    \"firstname\" : \"Hasan\",\n" +
                "    \"lastname\" : \"Ali\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
     */
    @Test
    public void testPOSTRequest(){

        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>();
        Faker faker = new Faker();
        

        jsonBodyUsingMap.put("firstname", faker.name().firstName());
        jsonBodyUsingMap.put("lastname", faker.name().lastName());
        jsonBodyUsingMap.put("totalprice", faker.random().nextInt(1000));
        jsonBodyUsingMap.put("depositpaid", faker.random().nextBoolean());

        Map<String, Object> bookingDateMap = new HashMap<>();
        bookingDateMap.put("checkin", "2024-05-01");
        bookingDateMap.put("checkout", "2024-05-25");

        jsonBodyUsingMap.put("bookingdates",bookingDateMap);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");







        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();
        Response response = requestSpecification.when().post();
        Integer bookingid = response.then().extract().path("bookingid");
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your Booking ID is : - " + bookingid);
    }
}
