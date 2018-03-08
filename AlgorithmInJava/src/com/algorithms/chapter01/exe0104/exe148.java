package com.algorithms.chapter01.exe0104;

import edu.princeton.cs.algs4.StdRandom;

public class exe148 {
    public static void main(String[] args) {
        int N = 100;
        int[] groupA = new int[N];

        for(int i = 0; i < N; i++) {
            groupA[i] = StdRandom.uniform(N);
        }
    }

}
