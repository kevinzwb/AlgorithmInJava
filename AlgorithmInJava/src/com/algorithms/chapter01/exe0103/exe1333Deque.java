package com.algorithms.chapter01.exe0103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class exe1333Deque {
    public static void main(String[] args) {
        Deque<String> test = new Deque<String>();
//
//        while (!StdIn.isEmpty())
//        {
//            String item = StdIn.readString();
//            if (!item.equals("-l") && !item.equals("-r")) {
//                if (item.equals("left")) test.pushLeft(item);
//                if (item.equals("right")) test.pushRight(item);
//            }
//            else if (!test.isEmpty()) {
//                if (item.equals("-l")) StdOut.print(test.popLeft()+ " ");
//                if (item.equals("-r")) StdOut.print(test.popRight() + " ");
//            }
//            for (String t:test) {
//                StdOut.print(t + " ");
//            }
//            StdOut.println();
//        }

        test.pushLeft("or");
        test.pushLeft("be");
        test.pushLeft("To");
        test.pushRight("not");
        test.pushRight("to");
        test.pushRight("be");
        for (String t:test) { StdOut.print(t + " "); }
        StdOut.println("\n");
        int size = test.size();
        for (int i = 0; i<size-3; i++) {
            test.popLeft();
            for (String t:test) { StdOut.print(t + " "); }
            StdOut.println();
        }
        StdOut.println("test");
        for (String t:test) { StdOut.print(t + " "); }


    }
}


class Deque<Item> implements Iterable<Item>{
    private DoubleNode head = new DoubleNode();
    private DoubleNode tail = new DoubleNode();
    private int N = 0;

    private class DoubleNode{
        Item item;
        DoubleNode previous;
        DoubleNode next;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void pushLeft(Item item){
        DoubleNode oldhead = head;
        head = new DoubleNode();
        head.item = item;
        head.previous = null;
        if (isEmpty()) tail = head;
        else {
            head.next = oldhead;
            oldhead.previous = head;
        }
        N++;
    }

    public void pushRight(Item item){
        DoubleNode oldtail = tail;
        tail = new DoubleNode();
        tail.item = item;
        tail.next = null;
        if (isEmpty()) head = tail;
        else{
            tail.previous = oldtail;
            oldtail.next = tail;
        }
        N++;
    }

    public Item popLeft(){
        Item item = head.item;
        head = head.next;
        N--;
        if (isEmpty()) tail = null;
        else head.previous = null;
        return item;
    }

    public Item popRight(){
        Item item = tail.item;
        tail = tail.previous;
        N--;
        if (isEmpty()) head = null;
        else tail.next = null;

        return item;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {return new DequeIterator();}

    private class DequeIterator implements Iterator<Item>
    {
        private DoubleNode current = head;

        public boolean hasNext() {return current != null;}

        public void remove() { }

        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}


//class ResizingArrayDeque<Item> implements Iterable<Item>{
//
//}
