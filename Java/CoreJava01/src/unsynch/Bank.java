package unsynch;

import java.util.*;

public class Bank
{
    private final double[] accounts;

    public Bank(int n , double initialBalance)
    {
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    public void tansfer(int from, int to,double amount)
    {
        if (accounts[from] < amount) return;
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from ,to);
        accounts[to] += amount;
        System.out.printf(" Totoal Balance: %10.2f%n", getTotoalBalance());
    }

    public double getTotoalBalance()
    {
        double sum = 0;

        for (double a :accounts)
            sum += a;

        return sum;

    }

    public int size()
    {
        return accounts.length;
    }
}
