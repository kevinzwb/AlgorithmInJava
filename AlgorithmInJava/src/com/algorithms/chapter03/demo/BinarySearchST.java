package com.algorithms.chapter03.demo;

import com.algorithms.chapter01.exe0101.BinarySearch;
import javafx.beans.binding.ObjectExpression;
import edu.princeton.cs.algs4.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value>{
    private Key[] keys;
    private Value[] vals;

    private int N;

    public BinarySearchST(){
        keys = (Key[]) new Comparable[1];
        vals = (Value[]) new Object[1];
        N = 0;
    }

    public int size(){
        return N;
    }

    public Value get(Key key) {
        if(isEmpty()) return null;
        int i  = rank(key);
        if(i < N && keys[i].compareTo(key) == 0)
            return vals[i];
        else
            return null;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int rank(Key key){
        int lo = 0,hi = N-1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0) hi = mid - 1 ;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key, Value val){
        if (N == keys.length) resize(2*keys.length);

        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            vals[i] = val;return;
        }

        for (int j = N; j > i ; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }

        keys[i] = key;
        vals[i] = val;

        N++;
    }

    private void resize(int max){
        Key[] keyTemp = (Key[]) new Comparable[max];
        Value[] valTemp = (Value[]) new Object[max];

        for (int i = 0; i < N; i++) {
            keyTemp[i] = keys[i];
            valTemp[i] = vals[i];
        }

        keys = keyTemp; vals = valTemp;
    }

    public void delete(Key key){

    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[N-1];
    }

//    public Key ceiling(Key key){
//        int i = rank(key);
//    }

//    public Key floor(Key key){
//
//    }

    public Iterable<Key> keys(){
        return keys(min(),max());
    }

    public Iterable<Key> keys(Key lo,Key hi){
       Queue<Key> q = new Queue<Key>();
        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(keys[i]);
        }

        if(contains(hi))
            q.enqueue(keys[rank(hi)]);

        return q;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }
}
