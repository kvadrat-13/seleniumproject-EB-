package com.cybertek.tests.day_14_test_base_props_drivers;

public class Singleton {
    // make constructor private
    private Singleton() {

    }

    private static String string;

    public static String getInstance() {
        if (string == null) {

            string = "chrome";
        }
        return string;
    }

}
