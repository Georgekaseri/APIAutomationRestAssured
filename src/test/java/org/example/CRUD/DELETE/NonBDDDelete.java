package org.example.CRUD.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDDelete {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token = "3faef0575afb657";


    @Test
    public void testPatchRequest(){
//

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/117");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);



        //Calling put method  on URI. After hitting we get Response
        Response response = requestSpecification.when().delete();

        // Get Validatable response to perform  validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);



    }
}
