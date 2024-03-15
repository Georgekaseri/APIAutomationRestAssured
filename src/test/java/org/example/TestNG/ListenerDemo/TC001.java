package org.example.TestNG.ListenerDemo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class TC001 {

    @Test(groups = "Sanity")
    public void test_1(){
        System.out.println("testCase_1");
        Assert.assertTrue(true);
    }
    @Test(groups = "Sanity")
    public void test_2(){
        System.out.println("testCase_2");
        Assert.assertTrue(true);
    }
}
