package org.example.CRUD.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDPATCH {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token = "3faef0575afb657";


    @Test
    public void testPatchRequest(){
//        String payload = "{\n" +
//                "    \"firstname\" : \"George\",\n" +
//                "    \"lastname\" : \"GK\",\n" +
//                "    \"totalprice\" : 1456,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2018-01-01\",\n" +
//                "        \"checkout\" : \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";
        String patch = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/117");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(patch).log().all();

        //Calling put method  on URI. After hitting we get Response
        Response response = requestSpecification.when().patch();

        // Get Validatable response to perform  validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("G"));
        validatableResponse.body("lastname", Matchers.equalTo("Hyderabad"));


    }
}
