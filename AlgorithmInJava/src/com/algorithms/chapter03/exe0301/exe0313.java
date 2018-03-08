package com.algorithms.chapter03.exe0301;

import edu.princeton.cs.algs4.Queue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 开发一个符号表的实现OrderedSequentalSearchST, 使用有序链表来实现我们的有序符号表API
public class exe0313 {
    public static void main(String[] args) throws IOException {
        String[] corpus = {"/home/wenbo/Dataset/algs4-data/tinyTale.txt",
                "/home/wenbo/Dataset/algs4-data/tale.txt",
                "/home/wenbo/Dataset/algs4-data/leipzig1M.txt"};
        Scanner input = new Scanner(new InputStreamReader(new FileInputStream(new File(corpus[1]))));
        String word;


        OrderedSequentalSearchST<String,Integer> st = new OrderedSequentalSearchST<>();

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

class OrderedSequentalSearchST<Key extends Comparable<Key>, Value>  implements ST<Key,Value>{

    private Node first;
    private int N;

    private class Node{
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next)
        {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    @Override
    public void put(Key key, Value val) {
        N++;

        if (isEmpty() || key.compareTo(first.key) < 0 ) {first = new Node(key,val,first);return;}

        Node currentNode;
        for (currentNode = first; currentNode != null; currentNode = currentNode.next) {
            if (key.equals(currentNode.key)) {
                currentNode.val = val;
                N--;
                return;
            }

            if(currentNode.next == null){
                Node newKey = new Node(key,val,null);
                currentNode.next = newKey;
                return;
            }

            if (key.compareTo(currentNode.next.key) < 0){
                Node newKey = new Node(key,val,currentNode.next);
                currentNode.next = newKey;
                return;
            }
        }
    }

    @Override
    public Value get(Key key) {
        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key))
                return x.val;
        return null;
    }

    @Override
    public void delete(Key key) {
        for(Node x = first; x != null; x = x.next){
            if(key.equals(x.next.key)){
                x.next = x.next.next;
                N--;
            }
        }

    }

    @Override
    public boolean contains(Key key) {
        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key))
                return true;
        return false;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Key min() {
        return first.key;
    }

    @Override
    public Key max() {
        Node x = first;
        while (x != null) x = x.next;
        return x.key;
    }

    @Override
    public Key floor(Key key) {
        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.next.key))
                return x.key;
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key))
                return x.next.key;
        return null;
    }

    @Override
    public int rank(Key key) {
        int position = 0;
        for(Node x = first; x != null; x = x.next) {
            position++;
            if (key.equals(x.key))
                return position;
        }
        return 0;
    }

    @Override
    public Key select(int k) {
        Node x = first;
        for (int i = 1; i < k; i++) {
            x = x.next;
        }
        return x.key;
    }

    @Override
    public void deleteMin() {
        first = first.next;
        N--;
    }

    @Override
    public void deleteMax() {
        Node x;
        for(x = first; x.next != null; x = x.next);
        x.next = null;
    }

    @Override
    public int size(Key lo, Key hi) {
        int distance = 0;
        for(Node x = first; x.key.equals(hi); x = x.next) {
            if (lo.compareTo(x.key) < 0)
                distance++;
        }
        return distance;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();

        for(Node x = first; x.key.equals(hi); x = x.next) {
            if (lo.compareTo(x.key) <= 0) queue.enqueue(x.key);
        }
        return queue;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();

        for(Node x = first; x != null; x = x.next) queue.enqueue(x.key);

        return queue;
    }
}
