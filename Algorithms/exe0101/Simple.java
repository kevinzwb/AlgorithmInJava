package exe0101;

import java.math.BigInteger;
import java.util.*;
import edu.princeton.cs.algs4.*;

import static exe0101.Simple.getType;
import static java.math.BigInteger.valueOf;
import static javafx.scene.input.KeyCode.N;

public class Simple {
    public static void main(String[] args)
    {
        System.out.println((0+15)/2);
        System.out.println(2.0e-6 * 100000000.1);
        System.out.println(true && false || true && true);

        System.out.printf("The result = %g,its type = %s \n",(1 + 2.236)/2,getType((1 + 2.236)/2));
        System.out.printf("The result = %g,its type = %s \n",1+2+3+4.0,getType(1+2+3+4.0));
        System.out.printf("The result = %b,its type = %s \n",4.1>=4,getType(4.1>=4));
        System.out.printf("The result = %s,its type = %s \n",1+2+"3",getType(1+2+"3"));

//        if (Integer.parseInt(args[0]) == Integer.parseInt(args[1]) &&
//                Integer.parseInt(args[1]) == Integer.parseInt(args[2]) &&
//                Integer.parseInt(args[2]) == Integer.parseInt(args[0])
//                ) System.out.println("Equal");
//        else System.out.println("Not Equal");

//        Scanner in = new Scanner(System.in);
//        System.out.print("Input three Integer:");
//        int firstInt = in.nextInt();
//        int secondInt = in.nextInt();
//        int thirdInt = in.nextInt();
//        if (firstInt == secondInt && secondInt == thirdInt && thirdInt == secondInt)
//            System.out.println("Equal");
//        else
//            System.out.println("Not Equal");

        int f = 0;
        int g = 1;
        for ( int i =0;i<=15;i++)
        {
            edu.princeton.cs.algs4.StdOut.println(f);
            f = f + g;
            g = f - g;
        }

        double t = 9.0;
        while(Math.abs(t - 9.0/t) > 0.001)
            t = (9.0/t + t ) / 2.0;
        edu.princeton.cs.algs4.StdOut.printf("%.5f\n",t);

        int sum = 0;
        for (int i = 1;i <1000;i++)
        {
            for (int j =0; j<i; j++)
            {
                sum++;
            }
        }
        edu.princeton.cs.algs4.StdOut.println(sum);

        sum = 0;
        for (int i =1; i< 1000 ; i*= 2)
            for (int j =0; j<1000; j++)
                sum++;
        edu.princeton.cs.algs4.StdOut.println(sum);

        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println(("a" + 4));

        System.out.println(exR1(6));

        System.out.println(mysteryPlus(2,25));
        System.out.println(mysteryPlus(3,11));
        System.out.println(mysteryMult(2,25));
        System.out.println(mysteryMult(3,11));

        System.out.println(lnN(7));
        System.out.println(lnN(1));
        System.out.println(lnN(2));

        System.out.println("Please input the name and two integer number(Format: name integer1 integer 2):");
        Scanner in = new Scanner(System.in);
        System.out.println("  Name | Num1 | Num2 | Result |");
        String info = in.nextLine();
        String[] infoargs = info.split(" ");
        String name = infoargs[0] + " " + infoargs[1];
        int firstNum = Integer.parseInt(infoargs[2]);
        int secondNum = Integer.parseInt(infoargs[3]);
        System.out.printf("  %s | %d | %d | %.3f |",name,firstNum ,secondNum ,(float)firstNum/secondNum);



    }


    public static String getType(Object o){
        return o.getClass().toString();
    }

    public static String exR1(int n)
    {
        if (n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }

    public static int mysteryPlus (int a, int b)
    {
        if(b == 0) return 0;
        if (b % 2 == 0) return mysteryPlus(a+a,b/2);
        return mysteryPlus(a+a,b/2)+a;
    }

    public static int mysteryMult (int a, int b)
    {
        if(b == 0) return 1;
        if (b % 2 == 0) return mysteryMult(a+a,b/2);
        return mysteryMult(a+a,b/2) * a;
    }

    public static double lnN(int N)
    {
        if (N == 1) return Math.log(N);
        return Math.log(N) + lnN(N-1);
    }
}


class Fiboacci
{
    public Fiboacci() {
    }

    public static long F(int N)
    {
        if ( N == 0) return 0;
        if ( N == 1) return 1;
        return F(N-1) + F(N-2);
    }

    public static void main (String[] args)
    {
        for (int N = 0; N<100; N++)
            edu.princeton.cs.algs4.StdOut.println(N + " " + F(N));
    }
}


class FiboacciArrayList
{
    public FiboacciArrayList() {
    }

    public static void main (String[] args)
    {
        ArrayList<BigInteger> fValue = new ArrayList();
        fValue.add(valueOf(0));
        fValue.add(valueOf(1));
        for (int N = 0; N<100; N++)
        {
            if (N > 1) fValue.add(fValue.get(N - 1).add(fValue.get(N - 2)));
            edu.princeton.cs.algs4.StdOut.println(String.format("%s %d", N, fValue.get(N)));
        }
    }
}


class FiboacciArray
{
    public FiboacciArray() {
    }

    public static void main (String[] args)
    {
        BigInteger[] fvalue = new BigInteger[100];
        fvalue[0] = BigInteger.valueOf(0);
        fvalue[1] = BigInteger.valueOf(1);
        for (int N = 0; N<100; N++)
        {
            if (N > 1) fvalue[N] = fvalue[N - 2].add(fvalue[N - 1]) ;
            edu.princeton.cs.algs4.StdOut.println(String.format("%s %d", N, fvalue[N]));
        }
    }
}
