package org.example.TestNG.testngexample;

import org.testng.annotations.Test;

public class PriorityDemo1 {

    @Test(priority = 1, groups = {"reg"})
    void demo1(){
        System.out.println("A");
    }

    @Test(priority = 2)
    void demo2(){
        System.out.println("B");
    }

    @Test
    void demo3(){
        System.out.println("C");
    }
}
