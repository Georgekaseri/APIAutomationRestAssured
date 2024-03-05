package org.example.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG007 {
    @Test(groups = {"sanity", "QA"})
    public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("Qa");

    }
    @Test(groups = {"reg", "sanity", "e2e", "Preprod"})
    public void regRun(){
        System.out.println("Reg");

    }
    @Test(groups = {"smoke", "sanity", "Dev"})
    public void smokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(true);
    }

}
