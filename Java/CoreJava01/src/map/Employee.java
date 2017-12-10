package map;

public class Employee 
{
    private String name;
    private double salary;


    public Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }


    public void rasieSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }



}
