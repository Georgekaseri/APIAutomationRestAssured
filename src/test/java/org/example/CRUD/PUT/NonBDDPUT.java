package org.example.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDPUT {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token = "a0824bef1b74a1f";


    @Test
    public void testPutRequest(){
        String payload = "{\n" +
                "    \"firstname\" : \"George\",\n" +
                "    \"lastname\" : \"GK\",\n" +
                "    \"totalprice\" : 1456,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/2819");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(payload).log().all();

        //Calling put method  on URI. After hitting we get Response
        Response response = requestSpecification.when().put();

        // Get Validatable response to perform  validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("George"));
        validatableResponse.body("lastname", Matchers.equalTo("GK"));


    }
}
