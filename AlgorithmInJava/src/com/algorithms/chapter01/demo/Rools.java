package com.algorithms.chapter01.demo;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Rools {

    public static void main(String[] args) {
        int T = Integer.parseInt("10000");
        int SIDES = 6;
        Counter[] rolls =new Counter[SIDES+1];
        for (int i =0; i<SIDES; i++)
            rolls[i] = new Counter(i+1 + "s");

        for (int t = 0; t < T;t++)
        {
            int result = StdRandom.uniform(0,SIDES);
            rolls[result].increment();
        }

        for (int i =0; i<SIDES; i++)
            StdOut.println(rolls[i]);

        StdOut.println(rolls.length);

    }
}
