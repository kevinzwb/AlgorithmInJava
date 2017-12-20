package com.algorithms.exe0102;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdOut;

public class exe123Interval2D {
    public static void main(String[] args) {
        int N = 10;
        Interval2D[] boxs = new Interval2D[N];

        for (int i = 0; i < N; i++) {
            Interval1D xinterval = Interval1DGenerated();
            Interval1D yinterval = Interval1DGenerated();
            boxs[i] = new Interval2D(xinterval,yinterval);
        }

        long startTime=System.currentTimeMillis();   //获取开始时间
        simpleFindIntersection(boxs);
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

    private static Interval1D Interval1DGenerated() {
        double lo =  Math.random();
        double hi =  Math.random();
        if (lo > hi){
            double temp = hi;
            hi = lo;
            lo = temp;
        }
        return new Interval1D(lo,hi);
    }

    private static void simpleFindIntersection(Interval2D[] boxs) {
        for (int i = 0; i < boxs.length; i++) {
            Interval2D firstbox = boxs[i];
            for (int j = i+1; j < boxs.length ; j++) {
                Interval2D secondbox = boxs[j];
                if (firstbox.intersects(secondbox))
                {
                    firstbox.draw();
                    secondbox.draw();
                    StdOut.println("Box[" + i + "] intersects with Box[" + j + "].");
                }

            }
        }
    }

}
