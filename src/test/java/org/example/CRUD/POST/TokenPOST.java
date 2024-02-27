package org.example.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TokenPOST {
    @Test
    public void testToken() {
        RequestSpecification token = RestAssured.given();
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        token.baseUri("https://restful-booker.herokuapp.com");
        token.basePath("/auth");
        token.contentType(ContentType.JSON);
        token.body(payload);

        Response response = token.when().post();

        ValidatableResponse validatableResponse = response.then();
        String responseString = response.asString();

        System.out.println(responseString );

        validatableResponse.statusCode(200);


    }
}
