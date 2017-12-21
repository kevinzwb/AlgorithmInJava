package com.algorithms.chapter01.exe0103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class exe133StackNumber {
    public static void main(String[] args) {
        int[][] outputs = new int[][]{  {4, 3, 2, 1, 0, 9, 8, 7, 6, 5},
                                        {4, 6, 8, 7, 5, 3, 2, 9, 0, 1},
                                        {2, 5, 6, 7, 4, 8, 9, 3, 1, 0},
                                        {4, 3, 2, 1, 0, 5, 6, 7, 8, 9},
                                        {1, 2, 3, 4, 5, 6, 9, 8, 7, 0},
                                        {0, 4, 6, 5, 3, 8, 1, 7, 2, 9},
                                        {1, 4, 7, 9, 8, 6, 5, 3, 0, 2},
                                        {2, 1, 4, 3, 6, 5, 8, 7, 9, 0},
                                        };
        for (int[] output:outputs)
        {
            Stack<Integer> numSeq = new Stack<Integer>(10);
            int N = 0;
            for (int num:output){
                while (N <= num){
                    numSeq.push(N++);
                    }
                if (numSeq.pop() == num)
                     StdOut.print(num + " ");
                else {
                    StdOut.print("illegal");
                    break;
                    }
                }
            StdOut.println();
        }
    }
}


class Stack<Item> {

    private Item[] a;
    private int N;

    Stack(int cap) {
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



}
