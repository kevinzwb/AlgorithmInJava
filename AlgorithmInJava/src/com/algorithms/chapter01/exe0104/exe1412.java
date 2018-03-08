package com.algorithms.chapter01.exe0104;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class exe1412 {
    public static void main(String[] args) {
        int N = 100;
        int[] groupA = new int[N];
        int[] groupB = new int[N];

        for (int i = 0; i < N; i++) {
            groupA[i] = StdRandom.uniform(N);
            groupB[i] = StdRandom.uniform(N);
        }

        Arrays.sort(groupA);
        Arrays.sort(groupB);
        Set<Integer> sameElements = new HashSet<>();

        for (int i = 0; i < N ; i++) {
            if (sameElements.contains(groupA)) continue;
            if (BinarySearch.rank(i,groupB)> 0)
                sameElements.add(groupA[i]);
        }

        for (Integer num:sameElements)
            StdOut.println(num);

        StdOut.println(sameElements.size());
    }
}
