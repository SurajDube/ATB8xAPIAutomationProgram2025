package com.thetestingacademy;

public class APITest004BuilderPatternDesignPattern {
   public APITest004BuilderPatternDesignPattern step1(){
       System.out.println("Step1 is started");
       System.out.println("Step1 is end");
       return this;
   }
    public APITest004BuilderPatternDesignPattern step2(){
        System.out.println("Step2 is started");
        System.out.println("Step2 is end");
        return this;
    }
    public APITest004BuilderPatternDesignPattern step3(String name){
        System.out.println("Step3 is started");
        System.out.println("Step3 is end");
        return this;
    }

    public static void main(String[] args) {
        APITest004BuilderPatternDesignPattern bp =new APITest004BuilderPatternDesignPattern();
        bp.step1().step2().step3("Suraj");
    }
}
