package com.algorithms.chapter02.textdemo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Multiway {
    public static void merge(In[] streams){

        int N = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<>(N);

        for (int i = 0; i < N; i++) {
            if(!streams[i].isEmpty())
                pq.insert(i,streams[i].readString());
        }

        while(!pq.isEmpty()){
            StdOut.println(pq.minKey());
            int i = pq.delMin();
            if(!streams[i].isEmpty())
                pq.insert(i,streams[i].readString());
        }
    }

    public static void main(String[] args) {
        int N = 3;
        String[] input = new String[3];
        input[0] = "/home/wenbo/Dataset/algs4-data/" + "m1" + ".txt";
        input[1] = "/home/wenbo/Dataset/algs4-data/" + "m2" + ".txt";
        input[2] = "/home/wenbo/Dataset/algs4-data/" + "m3" + ".txt";
//        input[0] = "A B C F G I I Z";
//        input[1] = "B D H P Q Q";
//        input[2] = "A B E F J N";
        In[] streams = new In[N];
        for (int i = 0; i < N; i++) {
            streams[i] = new In(input[i]);
        }
        merge(streams);
    }
}
