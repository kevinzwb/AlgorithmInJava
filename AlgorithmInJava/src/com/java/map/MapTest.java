package com.java.map;

import java.util.*;

public class MapTest {
    public static void main(String[] args)
    {

        Map<String, Employee> staff = new HashMap<>();
        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2646", new Employee("Harry Hacker"));
        staff.put("157-62-7935", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("Francesca Cruz"));

        // print all entires
        System.out.println(staff);

        //remove an entry
        staff.remove("567-24-2546");

        //replace an entry

        staff.put("456-62-5527", new Employee("Francesca Miller"));

        // look up a value
        System.out.println(staff.get("157-62-7935"));

        //iterate through all entires

        staff.forEach((k,v) ->
            System.out.println("key=" + k + ",value=" + v.getName() ));


    }
}
