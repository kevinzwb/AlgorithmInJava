package com.algorithms.chapter01.exe0103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class exe131FixedCapacityStackOfString<Item> {

    private Item[] a;
    private int N;

    exe131FixedCapacityStackOfString(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {return N == 0; }
    public boolean isFull()  {return N == a.length;}
    public int size()        {return N; }

    public void push(Item item) {
        if (!isFull()) a[N++] = item;
    }
    public Item pop() {
        if (!isEmpty()) return a[--N];
        else return null;
    }


    public static void main(String[] args) {
        exe131FixedCapacityStackOfString<String> s;
        s = new exe131FixedCapacityStackOfString<String>(5);
        while(!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if ( !item.equals("-"))  s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
