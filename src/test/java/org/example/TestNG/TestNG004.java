package org.example.TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG004 {

    @BeforeTest
    public void getToken(){
        System.out.println("1");
    }
    @BeforeTest
    public void getBookingID(){
        System.out.println("2");

    }
    @Test
    public void test(){
        //token and Booking ID
        System.out.println("3");
    }
}
