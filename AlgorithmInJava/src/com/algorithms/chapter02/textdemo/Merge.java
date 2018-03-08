package com.algorithms.chapter02.textdemo;

import java.io.IOException;

public class Merge extends Example{
    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable[] a,int lo,int hi){
        if (hi<= lo) return;
        int mid = lo + (hi - lo) /2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);

        merge(a,lo,mid,hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo,j =mid+1;

        for(int k = lo; k <=hi; k++){
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j],aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void main(String[] args) throws IOException {
        String[] items = input("words3");
        sort(items);
        assert isSorted(items);
        show(items);
    }

}
