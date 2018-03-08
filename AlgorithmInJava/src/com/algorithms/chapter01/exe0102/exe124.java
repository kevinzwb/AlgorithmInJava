package com.algorithms.chapter01.exe0102;

import edu.princeton.cs.algs4.StdOut;

public class exe124 {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;

        string1= "world";
        StdOut.println(string1);
        StdOut.println(string2);


        String s = "Hello World";
        s.toUpperCase();
        s.substring(6,11);
        StdOut.println(s);
    }
}
