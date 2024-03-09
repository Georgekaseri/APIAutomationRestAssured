package org.example.TestNG.ddt;

import org.testng.annotations.Test;

public class DDT01 {
    // Test Data - from the Excel File - Data Provider
    // Read the Excel File
    // Apache POI, - 60-70% - little difficult to understand first time.
    // Fillo Library - 30% - Super Easy!


    // Test case  login where we will inject the username and password

    // Excel There is not support directy in Java to Read the Excel file

    @Test(dataProvider = "getData", dataProviderClass = UtilExcel.class)
    public void testLogin(String username, String password){
        System.out.println("Username :  " + username);
        System.out.println("Password : " +  password);
    }
}
