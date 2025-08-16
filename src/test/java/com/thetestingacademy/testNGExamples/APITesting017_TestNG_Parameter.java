package com.thetestingacademy.testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting017_TestNG_Parameter {

    @Parameters("browser")
    @Test
    void demo1(String value) {
        System.out.println("Browser is " + value);
        // Open the Browser and select dadadada
        if (value.equalsIgnoreCase("chrome")) {
            System.out.println("Start my Testing");
        }
        if (value.equalsIgnoreCase("firefox")) {
            System.out.println("Start my Firefox");
        }
    }
}
