package com.thetestingacademy.sampleCheck;

public class APITest004BuilderDesignPattern {
   public APITest004BuilderDesignPattern step1(){
       System.out.println("Step1 is started");
       System.out.println("Step1 is end");
       return this;
   }
    public APITest004BuilderDesignPattern step2(){
        System.out.println("Step2 is started");
        System.out.println("Step2 is end");
        return this;
    }
    public APITest004BuilderDesignPattern step3 (String name){
        System.out.println("Step3 is started");
        System.out.println("Step3 is end");
        return this;
    }

    public static void main(String[] args) {
        APITest004BuilderDesignPattern bp =new APITest004BuilderDesignPattern();
        bp.step1().step2().step3("Suraj");
    }
}
