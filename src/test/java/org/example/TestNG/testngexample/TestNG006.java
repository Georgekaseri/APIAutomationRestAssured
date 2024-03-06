package org.example.TestNG.testngexample;

import org.testng.annotations.Test;

public class TestNG006 {
    @Test(priority =  1)
    public void t_1(){
        System.out.println("1");
    }
    @Test(priority =  2)
    public void t_2(){
        System.out.println("2");

    }
    @Test(priority =  3)
    public void t_3(){
        System.out.println("3");

    }
}
