package com.algorithms.chapter01.demo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSum {
    public static int count(int[] a){
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N ; j++) {
                for (int k = j+1; k < N; k++) {
                    cnt++;
                }
            }
         return cnt;
    }


    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
