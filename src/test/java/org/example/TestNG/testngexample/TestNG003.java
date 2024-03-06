package org.example.TestNG.testngexample;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG003 {
    String token;
    Integer bookingID;


    public  String getToken(){
        token = "123";
        return token;
    }

    @BeforeTest
    public void getTokenAndBookingID(){
        token = getToken();
        bookingID = 665;
    }

    @Test
    public void testPutRequest(){
        System.out.println(token);
        System.out.println(bookingID);
    }
}
