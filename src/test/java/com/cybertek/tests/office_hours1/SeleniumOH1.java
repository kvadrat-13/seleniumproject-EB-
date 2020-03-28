package com.cybertek.tests.office_hours1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SeleniumOH1 {

    /*
        - Iterator
            - List, Set, Map and other types of collections can use Iterator class to iterate over that collection
            - List has indexes (for i, for each, while, Iterator)
            - Map (for each, Iterator - to loop through keys)
        - Basic Selenium Navigations -

     */
    public static void main(String[] args) {

        // create arrayList of Strings - iterate over it
        ArrayList<String> keysToSearch = new ArrayList<>();

        keysToSearch.add("fruits");
        keysToSearch.add("vegetables");
        keysToSearch.add("beries");
        Iterator iterator = keysToSearch.iterator();

        //iterator() -> return Iterator type which we can use with all iterator methods
        // [fruits, veggies, berries]
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // print before modification and
        // add * to each string and print again
        Iterator<String> iterator1 = keysToSearch.iterator();
        while (iterator1.hasNext()) {
            String item = iterator1.next();
            System.out.println(item);
            System.out.println("*" + item);
        }

        // create a map with <String, String> personalInfo = new HashMap<>;
        HashMap<String, String> personalInfo = new HashMap<>();
        personalInfo.put("name", "Bryan");
        personalInfo.put("student_id", "21213124124123");
        personalInfo.put("major", "computer science");

        Iterator<String> mapIterator = personalInfo.keySet().iterator();
        while (mapIterator.hasNext()) {
            String key = mapIterator.next();
            System.out.println(mapIterator.next() + ":" + personalInfo.get(key));
        }
        WebDriver dr = new ChromeDriver();


    }

}

