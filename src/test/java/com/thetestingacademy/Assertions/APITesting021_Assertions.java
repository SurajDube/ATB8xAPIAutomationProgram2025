package com.thetestingacademy.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting021_Assertions {
    // TestNG Assertions
    // Expected Results = = Actual Results

    @Test
    public void test_HardAssertion(){
        System.out.println("Start");
        Assert.assertTrue(false);
        System.out.println("after");

        Assert.assertEquals("Suraj", "Suraj");
        Assert.assertEquals("Suraj", "suraj");
    }

    @Test
    public void test_SoftAssertion(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("Soft Assert is executing");
        softAssert.assertAll();
    }
}