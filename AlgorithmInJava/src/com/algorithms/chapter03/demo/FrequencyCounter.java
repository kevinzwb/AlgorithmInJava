package com.algorithms.chapter03.demo;

import edu.princeton.cs.algs4.StdIn;
import sun.misc.IOUtils;

import java.io.*;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;

public class FrequencyCounter {
    public static void main(String[] args) throws IOException {
//        String word,corpus = "/home/wenbo/Dataset/algs4-data/tinyTale.txt";
        String word,corpus = "/home/wenbo/Dataset/algs4-data/tale.txt";
//        String word,corpus = "/home/wenbo/Dataset/algs4-data/leipzig1M.txt";
        Scanner input = new Scanner(new InputStreamReader(new FileInputStream(new File(corpus))));
//        SequentualSearchST<String,Integer> st = new SequentualSearchST<>();
        BinarySearchST<String,Integer> st = new BinarySearchST<>();


        int minlen = 20;

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

        HashSet<String> queue = new HashSet<>();
        for(String key : st.keys()) {
            if (st.get(key) > st.get(max)) {
                queue.clear();
                queue.add(key);
                max = key;
            }
            if (st.get(key) == st.get(max)) queue.add(key);
        }

        for(String key : queue)
            System.out.println(key + " " + st.get(key));
    }
}
