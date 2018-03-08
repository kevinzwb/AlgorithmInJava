package com.algorithms.chapter03.exe0301;


import edu.princeton.cs.algs4.Queue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//开发一个符号表的实现ArrayST,使用无序数组来实现基本API
public class ex0312 {
    public static void main(String[] args) throws IOException {
        String[] corpus = {"/home/wenbo/Dataset/algs4-data/tinyTale.txt",
                         "/home/wenbo/Dataset/algs4-data/tale.txt",
                         "/home/wenbo/Dataset/algs4-data/leipzig1M.txt"};
        Scanner input = new Scanner(new InputStreamReader(new FileInputStream(new File(corpus[1]))));
        String word;


        ArrayST<String,Integer> st = new ArrayST<>();

        // test put,contain,get,keys
        int minlen = 8;

        while (input.hasNext())
        {
            word = input.next();
            if(word.length() < minlen) continue;

            if(!st.contains(word)) st.put(word,1);
            else  st.put(word,st.get(word)+1);
        }

        String max = " ";
        st.put(max,0);

        Iterable<String> box = st.keys();

        for(String key : st.keys())
            if(st.get(key) > st.get(max))
                max = key;
        System.out.println(max + " " + st.get(max));
    }
}

class  ArrayST<Key extends Comparable<Key>, Value> implements ST<Key,Value> {

    private Key[] keys;
    private Value[] vals;

    private int N;

    public ArrayST() {
        this.keys = (Key[]) new Comparable[1];
        this.vals = (Value[]) new Object[1];
        N = 0;
    }

    @Override
    public void put(Key key, Value val) {
        if (N == keys.length) resize(2*keys.length);

        int index = find(key);

        keys[index] = key;
        vals[index] = val;
        if(index == N) N++;

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

    @Override
    public Value get(Key key) {
        int index = find(key);
        return index < N ? vals[index]:null;
    }

    private int find(Key key){
        try {
            for (int i = 0; i < N; i++) {
                if (keys[i].compareTo(key) == 0 && vals[i] != null)
                    return i;
            }
        } catch (NullPointerException e){
            System.out.println(key);
        }
        return N;
    }

    @Override
    public void delete(Key key) {
        if ( N > 0 && N == keys.length/4) resize(keys.length/2);

        int index = find(key);
        vals[index] = null;
        for (int j = index; j < N-1 ; j++) {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }
        N--;
    }

    @Override
    public boolean contains(Key key) {
        return find(key) < N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Key min() {
        Key min = keys[0];
        for (int i = 1; i < N; i++) {
            if (min.compareTo(keys[i]) > 0)
                min = keys[i];
        }
        return min;
    }

    @Override
    public Key max() {
        Key max = keys[0];
        for (int i = 1; i < N; i++) {
            if (max.compareTo(keys[i]) < 0)
                max = keys[i];
        }
        return max;
    }

    @Override
    public Key floor(Key key) {
        Key floor = keys[0];
        for (int i = 1; i < N; i++) {
            if (floor.compareTo(key) < 0 &&floor.compareTo(keys[i]) < 0)
                floor = keys[i];
        }
        return floor;
    }

    @Override
    public Key ceiling(Key key) {
        Key ceiling = keys[0];
        for (int i = 1; i < N; i++) {
            if (ceiling.compareTo(key) < 0 &&ceiling.compareTo(keys[i]) < 0)
                ceiling = keys[i];
        }
        return ceiling;
    }

    @Override
    public int rank(Key key) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (keys[i].compareTo(key) < 0 && vals[i] != null)
                count++;
        }
        return count;
    }

    @Override
    public Key select(int k) {
        for (int i = 0; i < N; i++) {
            if (rank(keys[i]) == k)
                return keys[i];
        }
        return null;
    }

    @Override
    public void deleteMin() {
        delete(min());
    }

    @Override
    public void deleteMax() {
        delete(max());
    }

    @Override
    public int size(Key lo, Key hi) {
        if(hi.compareTo(lo) < 0)
            return 0;
        else if (contains(hi))
            return rank(hi) - rank(lo) + 1;
        else
            return rank(hi) - rank(lo);
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<Key>();
        if (size(lo,hi) > 0){
            for (int i = rank(lo); i <= rank(hi); i++) {
                q.enqueue(select(i));
            }
        }
        return q;
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(),max());
    }
}



