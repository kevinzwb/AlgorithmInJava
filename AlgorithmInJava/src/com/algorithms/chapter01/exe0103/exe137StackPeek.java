package com.algorithms.chapter01.exe0103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class exe137StackPeek {
    public static void main(String[] args) {
        StackWithNodes<String> s = new StackWithNodes<>();

        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + "");
        }

        StdOut.println("(" + s.size() + " left on stack)");
        StdOut.println(s.peek());
        StdOut.println(s.peek());
        s.pop();
        StdOut.println(s.peek());
        s.pop();
        StdOut.println(s.peek());


    }
}
