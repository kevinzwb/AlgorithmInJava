package com.algorithms.chapter01.exe0102;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;


public class exe121Point2D {
    public static void main(String[] args) {
        int N = 100000;
        Point2D[] pointGenerated = new Point2D[N];

        for (int i = 0; i < N ; i++) {
            double x = Math.random();
            double y = Math.random();
            pointGenerated[i] = new Point2D(x,y);
            pointGenerated[i].draw();
        }
        long startTime=System.currentTimeMillis();   //获取开始时间
        StdOut.println("The minimum distance between two point =" + simpleGetMinimumDistance(pointGenerated));
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

    public static double simpleGetMinimumDistance(Point2D[] points){
        double minimumDistance = 1;
        double tempDistance;
        for (int i = 0; i < points.length; i++) {
            Point2D firstPoint = points[i];
            for (int j = i+1; j < points.length ; j++) {
                Point2D secondPoint = points[j];
                tempDistance = firstPoint.distanceTo(secondPoint);
                if (minimumDistance > tempDistance)
                    minimumDistance = tempDistance;
            }
        }
        return minimumDistance;
    }
}
