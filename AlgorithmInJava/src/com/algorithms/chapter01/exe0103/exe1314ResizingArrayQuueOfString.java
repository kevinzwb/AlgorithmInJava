package com.algorithms.chapter01.exe0103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class exe1314ResizingArrayQuueOfString {
    public static void main(String[] args) {
        Queue<String> q = new Queue<>();

        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }

        StdOut.println("(" + q.size() + " left on stack)");
    }
}

class Queue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty(){return first == null;}

    public int size() {return N;}

    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if ( isEmpty()) last = null;
        N--;
        return  item;
    }



    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {return new QueueIterator();}

    private class QueueIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext() {return current != null;}

        public void remove() { }

        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();

        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }

        q.dequeue();
        q.dequeue();
        StdOut.println("(" + q.size() + " left on stack)");
    }
}

class ResizingQueue<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int head = 0,tail = 0;


    public boolean isEmpty(){return (tail - head) == 0;}

    public int size() {return tail - head;};

    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for (int i = head; i < tail; i++){
            temp[i-head] = a[i];
        }
        a = temp;
        tail = tail - head;
        head = 0;
    }

    public void enqueue(Item item){
        if (tail == a.length) resize(2*a.length);
        a[tail++] = item;
    }

    public Item dequeue(){
        Item item = a[head];
        a[head++] = null;
        if((tail - head) > 0 && (tail-head) == a.length/4) resize(a.length/2);
        return item;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {return new QueueIterator();}

    private class QueueIterator implements Iterator<Item>
    {
        private int i = head;

        public boolean hasNext() {return i < tail;}

        public void remove() { }

        public Item next()
        {
            return a[i++];
        }
    }

    public static void main(String[] args) {
        ResizingQueue<String> q = new ResizingQueue<>();

        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }

        StdOut.println("(" + q.size() + " left on stack)");

//        while (!StdIn.isEmpty())
//        {
//            String item = StdIn.readString();
//            q.enqueue(item);
//        }
//        for (Object word:q) {
//            StdOut.print(word + " ");
//        }
        StdOut.println("Queue Test");
    }
}