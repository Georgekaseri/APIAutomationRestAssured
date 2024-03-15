package org.example.Misc.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

public class SimpleSer {

    @Test
    public void test1(){
        Employee employeeObject = new Employee();
        employeeObject.setFirstName("Hasan Raffat");
        employeeObject.setLastName("Ali");
        employeeObject.setGender("Male");
        employeeObject.setAge(65);
        employeeObject.setSalary(50.000);
        employeeObject.setMarried(false);
        employeeObject.setGender("M");

        // Create a Gson object

        Gson gson = new Gson();
        String jsonEmployye = gson.toJson(employeeObject);
        System.out.println(jsonEmployye);

        Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
        String employeeJsonSringUsingJsonBuilder = gsonBuilder.toJson(employeeObject);
        System.out.println("Pretty JSON String :- ");
        System.out.println(employeeJsonSringUsingJsonBuilder);



    }

}
