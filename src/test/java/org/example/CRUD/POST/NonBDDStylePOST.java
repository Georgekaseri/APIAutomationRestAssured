package org.example.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStylePOST {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token = "a0824bef1b74a1f";
    @Test
    public void testNonBDDStylePOSTPositive(){


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
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().post();

        // Get Validatable response to perform  validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);



    }
}
