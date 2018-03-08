package com.algorithms.chapter04.demo;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SymbolGraph {

    private ST<String,Integer> st;
    private String[] keys;
    private Graph G;

    public SymbolGraph(String stream,String sp) throws FileNotFoundException {
        st = new ST<String,Integer>();
        Scanner input = new Scanner(new InputStreamReader(new FileInputStream(new File(stream))));

        while(input.hasNextLine()){
            String[] a = input.nextLine().split(sp);

            for (int i = 0; i < a.length; i++) {
                if(!st.contains(a[i]))
                    st.put(a[i],st.size());
            }
        }

        keys = new String[st.size()];

        for (String name : st.keys())
            keys[st.get(name)] = name;

        G = new Graph(st.size());
        input = new Scanner(new InputStreamReader(new FileInputStream(new File(stream))));
        while (!input.hasNextLine()){
            String[] a = input.nextLine().split(sp);
            int v =st.get(a[0]);
            for (int i = 0; i < a.length; i++) {
                G.addEdge(v,st.get(a[i]));
            }
        }
    }

    public boolean contains(String s){return st.contains(s);}

    public int index(String s) { return st.get(s);}

    public String name(int v) { return keys[v];}

    public Graph G()  {return G;}

    public static void main(String[] args) throws FileNotFoundException {


        String filename = "/home/wenbo/Dataset/algs4-data/routes.txt";

        String delim = " ";

        SymbolGraph sg = new SymbolGraph(filename, delim);

        Graph G = sg.G();

        Scanner input = new Scanner(new InputStreamReader(new FileInputStream(new File(filename))));

        while(input.hasNextLine()){
            String source = input.nextLine();
            for (int w : G.adj(sg.index(source.split(delim)[0])))
                StdOut.println(" " + sg.name(w));
        }
    }

}
