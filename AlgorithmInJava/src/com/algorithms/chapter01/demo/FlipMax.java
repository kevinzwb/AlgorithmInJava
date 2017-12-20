package com.algorithms.chapter01.demo;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class FlipMax {
    public static Counter max(Counter x, Counter y)
    {
        if (x.tally() > y.tally()) return x;
        else return y;
    }

    public static void main(String[] args) {
        int T = Integer.parseInt("10000");
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tail");

        for (int t = 0;t < T;t++)
            if (StdRandom.bernoulli(0.5))
                heads.increment();
        else tails.increment();

        if (heads.tally() == tails.tally())
            StdOut.println("Tie");
        else StdOut.println(max(heads,tails) + " wins");

    }
}
