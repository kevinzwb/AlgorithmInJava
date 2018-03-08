package com.algorithms.chapter01.exe0105;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class exe153 {
    public static void main(String[] args) {
        System.out.print("NULL");
    }
}

class WightedQuickUnionUF{

    private int[] id;
    private int[] sz;
    private int count;

    public WightedQuickUnionUF(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N ; i++)
            sz[i] = i;
    }

    public int getCount(){
        return count;
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    public int find(int p){
        while(p != id[p]) p = id[p];
        return p;
    }

    public void union(int p , int q){
        int i = find(p);
        int j = find(q);

        if (i == j) return;

        if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[i] = j;
            sz[j] += sz[i];
        }
        count--;
    }
}
