package org.example.TestNG.testngexample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG009 {

    @Test
    public void testCase01(){
        Assert.assertEquals(true,false,"Failed");
        System.out.println("This will not print");
    }
    public void testCase02(){
        Assert.assertEquals(true,false,"Failed");
        System.out.println("This will not print");
    }
}
