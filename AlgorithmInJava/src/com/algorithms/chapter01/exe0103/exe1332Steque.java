package com.algorithms.chapter01.exe0103;

public class exe1332Steque {
}

class Steque<Item>{
    private Node<Item> first;
    private Node<Item> last;
    private int N;

    public boolean isEmpty(){
       return true;
    }

    public int size(){
        return N;
    }

    public void push(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }
}
