package com.algorithms.chapter02.textdemo;

import edu.princeton.cs.algs4.StdRandom;

import java.io.IOException;

public class Quick extends Example {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable[] a,int lo,int hi){
        if(hi <= lo) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(Comparable[] a,int lo,int hi){
        int i =lo,j = hi +1;
        Comparable v = a[lo];

        while(true){
            while (less(a[++i],v)) if (i == hi) break;
            while(less(v,a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    public static void main(String[] args) throws IOException {
        String[] items = input("words3");
        sort(items);
        assert isSorted(items);
        show(items);
    }
}
