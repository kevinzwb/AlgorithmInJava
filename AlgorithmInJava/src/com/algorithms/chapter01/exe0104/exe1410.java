package com.algorithms.chapter01.exe0104;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class exe1410 {
    public static void main(String[] args) {
        int N = 10000;
        int[] groupA = new int[N];

        for(int i = 0; i < N; i++) {
            groupA[i] = StdRandom.uniform(N);
        }
        Arrays.sort(groupA);
        int key = StdRandom.uniform(N);
        int index = BinarySearch.rank(key,groupA);
        while(groupA[index] == groupA[index -1]) index--;
        StdOut.println(key + "  " + index);
    }
}
