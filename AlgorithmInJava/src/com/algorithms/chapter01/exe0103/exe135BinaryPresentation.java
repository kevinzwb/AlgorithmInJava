package com.algorithms.chapter01.exe0103;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class exe135BinaryPresentation {
    public static void main(String[] args) {
        StackWithNodes<Integer> stack = new StackWithNodes<>();
        int N = 50;
        while( N > 0){
            stack.push(N%2);
            N = N/2;
        }

        Iterator<Integer> itr = stack.iterator();
        while(itr.hasNext())
            StdOut.print(itr.next());

        StdOut.println();
        for (Iterator<Integer> it = stack.iterator(); it.hasNext(); ) {
            Integer d = it.next();
            StdOut.print(d);
        }


//        foreach does not work here
        StdOut.println();
        for (Object d:stack) StdOut.print((int)d);
    }

}
