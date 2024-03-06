package org.example.TestNG.testngexample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG013 {

    @DataProvider
    public Object[][] geData(){
return new Object[][]{
        new Object[]{"admin", "admin"},
        new Object[]{"admin", "password"},
        new Object[]{"admin", "password123"},
        new Object[]{"admin", " "},
        new Object[]{"admin", "123546658"},
        new Object[]{"admin", "!£$%%%$$£££"},
};
    }

    @Test(dataProvider = "geData")
    public void loginTes(String username, String password){
        System.out.println(username);
        System.out.println(password);
    }
}
