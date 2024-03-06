package org.example.TestNG.testngexample;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG008 {

    @Test
    public void testCase1(){
        /*
        Two Type of Assertion

                Soft Assertion
                    If you want the execution to proceed even if an assert fails,
                        SoftAssert sa = new SoftAssert();
                        sa.assertEquals(result, 2);
                        sa.assertEquals(result, 3);

                Hard Assertion
                    if you need your @Test Method to fail straight away after one of its Asserts fails, use Hard Asserts
                        Assert.assertEquals
         */
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(true,false,"True should not be equal to false");
        System.out.println("Please execute me");
        sa.assertAll();

        Assert.assertEquals(true,false,"Failed");
        System.out.println("This will not print");

    }
}
