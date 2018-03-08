package com.algorithms.chapter04.demo;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DepthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for(int w : G.adj(v)){
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)) return null;

        Stack<Integer> path = new Stack<Integer>();

        for(int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String corpus = "/home/wenbo/Dataset/algs4-data/tinyCG.txt";
        Scanner input = new Scanner(new InputStreamReader(new FileInputStream(new File(corpus))));
        Graph G = new Graph(input);

        int s = 0;
        DepthFirstPaths search = new DepthFirstPaths(G,s);

        for (int v = 0; v < G.V(); v++) {
            StdOut.print(s + " to " + v + ": " );
            if(search.hasPathTo(v))
                for (int x : search.pathTo(v))
                    if(x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
            StdOut.println();
        }

    }

}
