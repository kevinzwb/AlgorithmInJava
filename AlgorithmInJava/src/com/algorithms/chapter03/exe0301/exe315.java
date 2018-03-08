package com.algorithms.chapter03.exe0301;

import com.algorithms.chapter03.demo.BinarySearchST;
import edu.princeton.cs.algs4.Stack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class exe315 {
    public static void main(String[] args) throws IOException {
//        String word,corpus = "/home/wenbo/Dataset/algs4-data/tinyTale.txt";
        String word,corpus = "/home/wenbo/Dataset/algs4-data/tale.txt";
//        String word,corpus = "/home/wenbo/Dataset/algs4-data/leipzig1M.txt";
        Scanner input = new Scanner(new InputStreamReader(new FileInputStream(new File(corpus))));
        SequentualSearchST<String,Integer> st = new SequentualSearchST<>();
//        BinarySearchST<String,Integer> st = new BinarySearchST<>();

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

class SequentualSearchST<Key,Value> {
    private Node first;

    private class Node{
        Key key;
        Value val;
        Node next;

        public Node(Key key,Value val,Node next)
        {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    public Value get(Key key){
        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key))
                return x.val;
        return null;
    }

    public void put(Key key,Value val){
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key,val,first);
    }

    public boolean contains(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return true;
            }
        }
        return false;
    }

    public int size(){
        int i = 0;
        for (Node x = first; x != null; x = x.next) {i++;}
        return i;
    }

    public void delete(Key key){
        for (Node x = first; x.next != null; x = x.next) {
            if (key.equals(x.next.key)) {
                x.next = x.next.next;
            }
        }
    }

    public Iterable<Key> keys() {
        Stack<Key> stack = new Stack<>();
        for (Node x = first; x != null; x = x.next) {
            stack.push(x.key);
        }
        return stack;
    }


}

