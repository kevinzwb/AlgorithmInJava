package com.algorithms.chapter04.demo;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }

    private void bfs(Graph G, int s){
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true;
        queue.enqueue(s);

        while (!queue.isEmpty()){
            int v = queue.dequeue();
            for (int w :G.adj(v)){
                edgeTo[w] = v;
                marked[w] = true;
                queue.enqueue(w);
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
