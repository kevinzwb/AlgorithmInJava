package com.java.arrayList;

import java.util.*;

public class ArrayListTest {

    public static void main(String[] args)
    {
        //fill the staff array list with thre Employee objects
        ArrayList<Employee> staff = new ArrayList<Employee>();

        staff.add(new Employee("Carl Cracker",75000,1987,12,15));
        staff.add(new Employee("Harry Hacker",50000,1989,10,1));
        staff.add(new Employee("Tony Tester",40000,1990,3,15));

        for (Employee e :staff)
            e.rasieSalary(5);

        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ".hireday=" + e.getSalary());
    }
}
