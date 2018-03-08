package com.algorithms.chapter02.textdemo;

import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Selection extends Example {
    public static void sort(Comparable[] a){
//        StdOut.println("Selection");
        int N = a.length;
        for (int i = 0; i < N;i++){
            int min = i;
            for (int j = i+1;j< N; j++){
                if(less(a[j],a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) throws IOException {
        String[] items = input("words3");
        sort(items);
        assert isSorted(items);
        show(items);
    }

}
