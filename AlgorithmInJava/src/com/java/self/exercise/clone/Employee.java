package com.java.self.exercise.clone;

import java.util.Date;
import java.util.GregorianCalendar;

class Employee implements Cloneable{

    private String name;
    private int salary;
    private Date hireDay;
    private int id ;

    private static int MemberNum = 0;


    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.hireDay = new Date();
        MemberNum++;
        this.id = MemberNum;

    }

    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();

        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    public void setHireDay(int year,int month,int day) {
        Date newHireDay = new GregorianCalendar(year, month -1, day).getTime();
        hireDay.setTime(newHireDay.getTime());
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
