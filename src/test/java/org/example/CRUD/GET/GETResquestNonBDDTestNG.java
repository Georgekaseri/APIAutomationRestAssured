package org.example.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GETResquestNonBDDTestNG {
    @Test
    public void testGetAllBookingPositive() {


        RequestSpecification r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/500029");

        r.when().log().all().get();
        r.then().log().all().statusCode(200);


    }

    @Test
    public void testGetAllBookingPositiveAll() {


        RequestSpecification a = RestAssured.given();
        a.baseUri("https://api.zippopotam.us");
        a.basePath("/IN");

        a.when().log().all().get();
        a.then().log().all().statusCode(200);

    }

    @Test
    public void testGetAllBookingNegative() {


        RequestSpecification b = RestAssured.given();
        b.baseUri("https://api.zippopotam.us");
        b.basePath("/IN/-1");

        b.when().log().all().get();
        b.then().log().all().statusCode(200);
    }
}
