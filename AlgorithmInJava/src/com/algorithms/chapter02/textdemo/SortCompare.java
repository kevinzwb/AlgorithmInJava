package com.algorithms.chapter02.textdemo;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(String alg,Double[] a){
        Stopwatch timer= new Stopwatch();

        if(alg.equals("Insertion")) Insertion.sort(a);
        if(alg.equals("Selection")) Selection.sort(a);
        if(alg.equals("Shell")) Shell.sort(a);
        if(alg.equals("MergeBU")) Merge.sort(a);
        if(alg.equals("Merge")) MergeBU.sort(a);

        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg,int N,int T){
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg,a);
        }
        return total;
    }

    public static void main(String[] args) {
        String[] algs = {"Insertion","Selection","Shell","Merge","MergeBU"};
        int N = 100000;
        int T = 1000;
        StdOut.printf("For %d random Doubles, \n",N);
        for (String alg:algs){
            double t = timeRandomInput(alg,N,T);
            StdOut.printf("%s is %.3f seconds\n",alg,t);
        }

    }
}
