package com.algorithms.chapter01.exe0104;

import com.algorithms.chapter01.demo.DoublingTest;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;


public class exe143 {
    public static void main(String[] args) {
        int N = 10000;
        StdDraw.setXscale(100,10000);
        StdDraw.setYscale(0,1);
        StdDraw.setPenRadius(0.01);
        for (int i = 1; i < N; i++) {
            double time = DoublingTest.timeTrial(i);
            StdDraw.point(i,time);
            StdOut.println(i + " " + time);
        }
    }

}
