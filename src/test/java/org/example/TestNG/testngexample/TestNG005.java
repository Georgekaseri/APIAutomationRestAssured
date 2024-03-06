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

import static org.assertj.core.api.Assertions.assertThat;

public class TestNG005 {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;

    @BeforeTest
    public void getToken() {
        System.out.println(" ************ Get Token ************ ");
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
        validatableResponse = response.then();
        // Rest Assured Matchers
        validatableResponse.body("token", Matchers.notNullValue());
        //TestNG Assertion
        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);
        // AssertJ
        assertThat(token).isNotNull().isNotBlank().isNotEmpty();



    }

    @BeforeTest
    public void getBookingID(){
        System.out.println(" ************ Booking ID ************");
        String payload = "{\n" +
                "    \"firstname\" : \"Mohammed\",\n" +
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
        bookingID = response.then().log().all().extract().path("bookingid");
        System.out.println(bookingID);

    }
    @Test
    public void testPUTRequest(){
        System.out.println(" *********************** Test Case PUT Request *********************** ");
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
        requestSpecification.basePath("/booking/" + bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(jsonString).log().all();



        //Calling put method  on URI. After hitting we get Response
        Response response = requestSpecification.when().put();
        System.out.println(response.asString());

        // Get Validatable response to perform  validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Hasan"));
        validatableResponse.body("lastname", Matchers.equalTo("GK"));

    }


    @Test
    public void testPUTRequestFirstName(){
        System.out.println(" *********************** Test Case PUT Request *********************** ");
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
        requestSpecification.basePath("/booking/" + bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(jsonString).log().all();



        //Calling put method  on URI. After hitting we get Response
        Response response = requestSpecification.when().put();
        System.out.println(response.asString());

        // Get Validatable response to perform  validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        String firstName = response.then().log().all().extract().path("firstname");
        assertThat(firstName).isNotNull().isNotBlank().isNotEmpty();

    }
}