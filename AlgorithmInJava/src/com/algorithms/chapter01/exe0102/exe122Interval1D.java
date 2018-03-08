package com.algorithms.chapter01.exe0102;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdOut;

public class exe122Interval1D {
    public static void main(String[] args) {
        int N = 10;
        Interval1D[] intervalGenerated = new Interval1D[N];

        for (int i = 0; i < N; i++) {
            double lo =  Math.random();
            double hi =  Math.random();
            if (lo > hi){
                double temp = hi;
                hi = lo;
                lo = temp;
            }
            intervalGenerated[i] = new Interval1D(lo,hi);
        }

        long startTime=System.currentTimeMillis();   //获取开始时间
        simpleFindIntersection(intervalGenerated);
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

    private static void simpleFindIntersection(Interval1D[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            Interval1D firstinterval  = intervals[i];
            for (int j = i+1; j < intervals.length ; j++) {
                Interval1D secondinterval = intervals[j];
                if (firstinterval.intersects(secondinterval))
                {
                    StdOut.println("Interval[" + i + "] intersects with interval[" + j + "].");
                }

            }
        }
    }

}
