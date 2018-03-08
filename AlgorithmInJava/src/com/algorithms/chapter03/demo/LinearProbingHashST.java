package com.algorithms.chapter03.demo;

public class LinearProbingHashST<Key,Value> {

    private int N;
    private int M = 16;
    private Key[]   keys;
    private Value[] vals;

    public LinearProbingHashST(){

        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int size){

    }

    public void put(Key key, Value val){
        if (N >= M/2) resize(2*M);

        for (int i = hash(key); keys[i] != null ; i = (i + 1) % M) {
            if (keys[i].equals(key)){
                vals[i] = val;
                return;
            }
            keys[i] = key;
            vals[i] = val;
            N++;
        }
    }

    public Value get(Key key){
        for (int i = hash(key); keys[i] != null ; i = (i+1)%M) {
            if(keys[i].equals(key))
                return vals[i];
        }
        return null;
    }



}
