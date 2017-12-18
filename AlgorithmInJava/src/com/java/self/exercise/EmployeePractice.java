package com.java.self.exercise;

import java.time.LocalDate;

public class EmployeePractice {
    public static void main(String[] args) {
        Employee[] members = new Employee[3];

        members[0] = new Employee("Xiaoming",10000,2001,12,3);
        members[1] = new Employee("Xiaoqiang",20000,2008,2,13);
        members[2] = new Employee("Xiaohong",30000,20017,7,26);

        for (Employee member:members) {
            member.raiseSalaryPercent(10);
            System.out.println(member.toString());
        }


    }
}

class Employee{

    private String name;
    private int salary;
    private LocalDate hireDay;
    private int id ;

    private static int MemberNum = 0;


    public Employee(String name, int salary, int year, int month,int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
        MemberNum++;
        this.id = MemberNum;

    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalaryPercent(double percent){
        salary += salary*(percent/100);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                "id=" + id  +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}
