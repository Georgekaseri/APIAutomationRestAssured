package org.example.CRUD.GET;

import io.restassured.RestAssured;

public class RATestCase1 {
    public static void main(String[] args) {


        // GET Request - https://api.zippopotam.us/IN/500029
        // URL
        // Header ?
        // GET Method
        // Base url = https://api.zippopotam.us
        // BasePath = /IN/500029
        // PayLoad = No
        // Auth - Basic, Digest = NO


        /*
                        Check
                        ------
        Status Code
        Response Body
        Time, Headers, Cookies

                                Gherkin
                              -----------
         Given
         When
         Then


         Given : -

         GET Request - https://api.zippopotam.us/IN/500029
         URL
         Header ?
         Base url = https://api.zippopotam.us
         BasePath = /IN/500029
         Auth - Basic, Digest = NO

         When : -

         Payload
         HTTP Methods


         Then : -

         Response
         Validation
         Status Code
         Response Body
         Time, Header, Cookies


         */

RestAssured
        .given()
        .baseUri("https://restful-booker.herokuapp.com")
        .basePath("/booking/557")

        .when().log().all()
        .get()

        .then().log().all().statusCode(200);

    }

}
