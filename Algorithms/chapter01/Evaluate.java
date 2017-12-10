package Algorithms.chapter01;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Evaluate
{
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals=new Stack<Double>();

        while(!StdIn.isEmpty())  // Bug: not stop. Need to use Ctrl + D to break
        {
            String s = StdIn.readString();
            if (s.equals("("));
            else if(s.equals("+"))  ops.push(s);
            else if(s.equals("-"))  ops.push(s);
            else if(s.equals("*"))  ops.push(s);
            else if(s.equals("/"))  ops.push(s);
            else if(s.equals("sqrt"))  ops.push(s);
            else if(s.equals(")"))
            {
                String op = ops.pop();
                double v  = vals.pop();
                if (op.equals("+"))   v = vals.pop() + v;
                if (op.equals("-"))   v = vals.pop() - v;
                if (op.equals("*"))   v = vals.pop() * v;
                if (op.equals("/"))   v = vals.pop() / v;
                if (op.equals("sqrt"))   v = Math.sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(s));
            println("hello3");
        }
        println("hello1");
        println(vals.pop());
        println("hello2");
    }
}

class readIn
{
    public static void main(String[] args) {
        println("Start");
        while(!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            println(s);
        }

        println("End");
    }
}
