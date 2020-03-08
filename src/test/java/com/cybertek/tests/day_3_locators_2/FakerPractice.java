package com.cybertek.tests.day_3_locators_2;

import com.github.javafaker.Faker;

public class FakerPractice {
    public static void main(String[] args) {

        //create Faker object
        Faker fakeData = new Faker();

        // Ineed firstName


        String name1 = fakeData.gameOfThrones().dragon();
        System.out.println("name = " + name1);

        for (int i = 0; i < 10000; i++) {
            String name = fakeData.name().firstName();
            if (name.contains("Renda")) {
                System.out.println("I have found Renda");
                continue;
            }else if(name.contains("Meleys")){
                System.out.println("I have found Meleys");
            }
        }

    }
}
