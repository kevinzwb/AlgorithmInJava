package com.algorithms.chapter04.demo;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.Scanner;

public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        this.E = 0;

        adj = (Bag<Integer>[]) new Bag[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    public Graph(Scanner in){
        this(in.nextInt());
        int E = in.nextInt();

        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v,w);
        }
    }

    public int V(){return V;}
    public int E(){return E;}
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}

