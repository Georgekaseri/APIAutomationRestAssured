package org.example.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class TestPutResquest {

    RequestSpecification forUnderstanding;
    ValidatableResponse forYoursUnderstading;
    String token = "261b33842a89e8a";

    @Test
    public void hasanBhaiTest(){

        String payload = "{\n" +
                "    \"firstname\": \"George\",\n" +
                "    \"lastname\": \"Kaseri\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";

        forUnderstanding = RestAssured.given();
        forUnderstanding.baseUri("https://restful-booker.herokuapp.com");
        forUnderstanding.basePath("/booking/1299");
        forUnderstanding.contentType(ContentType.JSON);
        forUnderstanding.cookie("Token", token);
        forUnderstanding.body(payload).log().all();

        Response response = forUnderstanding.when().put();


        forYoursUnderstading = response.then().log().all();
        forYoursUnderstading.statusCode(200);
        forYoursUnderstading.body("firstname", Matchers.equalTo("George"));
        forYoursUnderstading.body("lastname", Matchers.equalTo("Kaseri"));





    }
}
