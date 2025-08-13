package com.thetestingacademy.sampleCheck;

public class APITest003NonDesignPattern {
    public void step1() {
        System.out.println("step 1 ");
    }

    public void step2() {
        System.out.println("step 2 ");
    }

    public void step3(String s1) {
        System.out.println("step 3 ");
    }


    public static void main(String[] args) {
        APITest003NonDesignPattern ndp = new APITest003NonDesignPattern();
        ndp.step1();
        ndp.step2();
        ndp.step3("Suraj");
    }
}
