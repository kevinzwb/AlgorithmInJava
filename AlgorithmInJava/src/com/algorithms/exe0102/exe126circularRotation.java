package com.algorithms.exe0102;

import edu.princeton.cs.algs4.StdOut;

public class exe126circularRotation {
    public static void main(String[] args) {
        String a = "ACTGACGT";
        String b = "TGACGAC";

        if (a.length() == b.length() && ((a+a).indexOf(b))>=0)
            StdOut.println("Yes,Ture");
        else
            StdOut.println("No,False");
    }
}
