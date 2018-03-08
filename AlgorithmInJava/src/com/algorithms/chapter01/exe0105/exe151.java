package com.algorithms.chapter01.exe0105;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.*;

public class exe151 {
    public static void main(String[] args) {
        int a = 1;
    }

}

class UF_quickfind{
    private int[] id;
    private int count;

    public UF_quickfind(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int p ){
        return id[p];
    }

    public void union(int p ,int q){
        int pID = find(p);
        int qID = find(q);

        if ( pID == qID) return;

        for (int i = 0; i < id.length; i++) {
            if(id[i] == pID) id[i] = qID;
        }
        count--;
    }

    public static void main (String[] args) throws IOException {

        String text = "/home/wenbo/Project/AlgorithmInJava/src/com/algorithms/chapter01/exe0105/text151.txt";
        FileInputStream textFile = new FileInputStream(new File(text));
        BufferedReader buffer = new BufferedReader(new InputStreamReader(textFile));
        int N = 10;
        UF_quickfind uf = new UF_quickfind(N);
        String line;
        while ((line = buffer.readLine()) != null){
            String[] inputs = line.split("-");
            int p = Integer.valueOf(inputs[0]);
            int q = Integer.valueOf(inputs[1]);
            if (uf.connected(p,q)) continue;
            uf.union(p,q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + "components");
    }
}
