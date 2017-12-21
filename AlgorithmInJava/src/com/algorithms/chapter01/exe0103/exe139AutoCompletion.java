package com.algorithms.chapter01.exe0103;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

import static edu.princeton.cs.algs4.StdOut.println;

public class exe139AutoCompletion {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<String> vals= new Stack<>();

        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals("+"))  ops.push(s);
            else if(s.equals("-"))  ops.push(s);
            else if(s.equals("*"))  ops.push(s);
            else if(s.equals("/"))  ops.push(s);
            else if(s.equals(")"))
            {
                String op = ops.pop();
                String v  = vals.pop();
                v = "(" + vals.pop() + op + v + ")";
                vals.push(v);
            }
            else vals.push(s);
        }
        println(vals.pop());

    }
}
