package org.example.TestNG;

import org.testng.annotations.*;

public class TestNG001 {

    @BeforeSuite
    void demo1(){
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    void demo2(){
        System.out.println("BeforeTest");
    }

    @BeforeClass
    void demo3(){
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    void demo4(){
        //Read of Excel file
        // file Text, Json,CSV, Database
        // Configuration load
        System.out.println("BeforeMethod");
    }
    @Test
    void demo5(){
        System.out.println("Test 1");

    }


    @AfterMethod
    void demo6(){
        // Close the files here
        System.out.println("AfterMethod");
    }

    @AfterClass
    void demo7(){
        System.out.println("AfterClass");

    }
    @AfterTest
    void demo8(){
        System.out.println("AfterTest");
    }
    @AfterSuite
    void demo9(){
        System.out.println("AfterSuite");
    }
}
