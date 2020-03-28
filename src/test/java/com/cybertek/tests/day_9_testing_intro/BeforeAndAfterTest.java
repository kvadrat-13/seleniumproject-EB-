package com.cybertek.tests.day_9_testing_intro;

import org.testng.Assert;
import org.testng.annotations.*;

public class BeforeAndAfterTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("\tBEFORE CLASS");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("\tAFTER CLASS");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\tBEFORE METHOD");
    }

    @AfterMethod
    public void afterMEthod() {
        System.out.println("\tAFTER METHOD");
    }




    @Test
    public void test1() {
        System.out.println("this is test one");

//        Assert.assertEquals(5, 10); ->fails here
    }

    //    @Ignore
    @Test
    public void test2() {
        System.out.println("this is test two");
    }
}

