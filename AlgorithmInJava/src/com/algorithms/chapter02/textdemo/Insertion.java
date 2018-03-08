package com.algorithms.chapter02.textdemo;

import edu.princeton.cs.algs4.StdOut;

import java.io.IOException;

public class Insertion extends Example{
    public static void sort(Comparable[] a){
//        StdOut.println("Insertion");
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j> 0 && less(a[j],a[j-1]); j--) {
                exch(a,j,j-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String[] items = input("words3");
        sort(items);
        assert isSorted(items);
        show(items);
    }
}
