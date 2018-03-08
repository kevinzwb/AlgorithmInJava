package com.java.equals;

import com.java.textFile.Employee;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day)
    {
        super(name,salary,year,month,day);
        bonus = 0;
    }

    public double getSalary()
    {
      double baseSalary = super.getSalary();
      return baseSalary + bonus;
    }

    public void setBonus(double b)
    {
        this.bonus = b;
    }

    public boolean equals(Object otherObject)
    {
        if (!super.equals(otherObject)) return false;
        Manager other = (Manager) otherObject;
        return bonus == other.bonus;
    }


    public String toString()
    {
        return super.toString() + "[bonus=" +  bonus + "]";
    }
}
