package com.algorithms.exe0102;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class exe1210VisualCounter {

    private double total;
    private int N;
    private int max;

    public exe1210VisualCounter(int trials,int max)
    {
        this.max = max;
        StdDraw.setXscale(0,trials);
        StdDraw.setYscale(0,max);
        StdDraw.setPenRadius(.005);
    }

    public void add(){
        N++;
        if (total< max)
            total++;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N,total);
    }

    public void minus(){
        N++;
        if (total > 0)
            total--;
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N,total);
    }

    public static void main(String[] args) {
//        int T = Integer.parseInt(args[0]);
        int T = 1000;
        exe1210VisualCounter a = new exe1210VisualCounter(T,50);
        for (int t = 0; t < T; t++) {
            if (StdRandom.bernoulli() == true)
                a.add();
            else
                a.minus();
        }
        StdOut.println(a.total);
    }

}
