package com.algorithms.chapter03.demo;

public class SeparateChainingHashST<Key,Value> {
    private int N;
    private int M;
    private SequentualSearchST<Key,Value>[] st;

    public SeparateChainingHashST(){
        this(997);
    }

    public SeparateChainingHashST(int M){
        this.M = M;
        st = (SequentualSearchST<Key,Value>[]) new SequentualSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentualSearchST<>();
        }
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private Value get(Key key){
        return (Value) st[hash(key)].get(key);
    }

    private void put(Key key, Value val){
        st[hash(key)].put(key,val);
    }
//
//    public Iterable<Key> keys(){
//
//    }
}
