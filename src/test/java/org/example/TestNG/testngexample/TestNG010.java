package org.example.TestNG.testngexample;

import org.testng.annotations.Test;

public class TestNG010 {
    @Test
    public void serverStartedOK(){
        System.out.println("I will run first");
    }
    @Test(dependsOnMethods = "serverStartedOK")
    public void method1(){
        System.out.println("Method1");
    }
}
