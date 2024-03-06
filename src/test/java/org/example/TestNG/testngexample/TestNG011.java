package org.example.TestNG.testngexample;

import org.testng.annotations.Test;

public class TestNG011 {

    @Test(groups = {"inIt"}, priority = 1)
    public void getToken(){
        System.out.println("serverStartedOK");
    }
    @Test(groups = {"inIt"}, priority = 2, enabled = false)
    public void getBookingID(){
        System.out.println("inItEnvironment");
    }
    @Test(dependsOnGroups = {"inIt.*"})
    public void testPutRequest(){
        System.out.println("Now I will run");
    }
}
