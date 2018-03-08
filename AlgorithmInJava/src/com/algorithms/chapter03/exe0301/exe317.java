package com.algorithms.chapter03.exe0301;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class exe317 {
    public static void main(String[] args) {
        Random generator = new Random();
        int number;
        int[] N = new int[]{10,100,1000,10000,100000,1000000};
        for (int j = 0; j < N.length ; j++) {
            HashSet<Integer> container = new HashSet<>();
            for (int i = 0; i < N[j]; i++) {
                container.add(generator.nextInt(1000));
            }
            System.out.println(N[j] + " " + container.size());
        }
    }
}
