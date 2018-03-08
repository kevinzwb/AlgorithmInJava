package com.algorithms.chapter02.textdemo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.*;
import java.util.Scanner;

public class Example {

    public static void sort(Comparable[] a){
        StdOut.println("Example");
    }

    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a){
        for ( int i = 0;i<a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++)
            if(less(a[i],a[i-1])) return false;
            return true;
    }

    public static String[] input(String fileName) throws IOException {
        String fileAddress = "/home/wenbo/Dataset/algs4-data/" + fileName + ".txt";
        FileInputStream file = new FileInputStream(fileAddress);
        BufferedReader input = new BufferedReader(new InputStreamReader(file));
        String line,content = "";
        while((line = input.readLine()) != null)
            content += line;

        String[] items = content.split(" ");
        show(items);
        return items;
    }

}
