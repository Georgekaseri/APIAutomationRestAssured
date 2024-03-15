package org.example.TestNG.testngexample;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestNG002 {
    RequestSpecification requestSpecification;
    ValidatableResponse  validatableResponse;
    String token;

    @BeforeTest
    public void getToken(){

        requestSpecification = RestAssured.given();
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        Response response = requestSpecification.post();
        validatableResponse =response.then();

        // Rest Assured Matchers
        validatableResponse.body("token", Matchers.notNullValue());

        //TestNG Assertion
        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);

        // AssertJ
        assertThat(token).isNotNull().isNotBlank().isNotEmpty();


        System.out.println(token);
    }
    @Test
    public void testPutRequest(){
        String jsonString = "{\n" +
                "    \"firstname\" : \"Hasan\",\n" +
                "    \"lastname\" : \"GK\",\n" +
                "    \"totalprice\" : 1456,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/2958");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(jsonString);



        //Calling put method  on URI. After hitting we get Response
        Response response = requestSpecification.when().put();
        System.out.println(response.asString());

        // Get Validatable response to perform  validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Hasan"));
        validatableResponse.body("lastname", Matchers.equalTo("GK"));


    }

}
