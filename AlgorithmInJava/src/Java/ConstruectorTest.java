/*
import java.util.*;

public class ConstruectorTest
{
    public static void main(String[] args)
    {
        Employee[] staff = new Employee[3];


        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();

        //print out information about all Employee objects
        for (Employee e : staff)
        {
            System.out.println("name = " + e.getName() + ",id = " + e.getId() + ",salary=" + e.getSalary());
        }
    }
}


class Employee
{
    private static int nextId;

    private String name = ""; //instance field initialization
    private double salary;
    private int id;

    //static initialization block
    static
    {
        Random generator = new Random();
        //set nextId to a random number betweeen 0 and 9999
        nextId = generator.nextInt(10000);
    }

    //objct initialization block
    {
        id = nextId;
        nextId++;
    }

    public Employee(String n,double s)
    {
        name = n;
        salary = s;
    }


    public Employee(double s)
    {
        salary = s;
    }


    public Employee()
    {

    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public int getId()
    {
        return id;
    }

}*/
