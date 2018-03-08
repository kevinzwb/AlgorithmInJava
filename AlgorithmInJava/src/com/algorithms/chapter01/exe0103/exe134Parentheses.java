package com.algorithms.chapter01.exe0103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class exe134Parentheses {
    public static void main(String[] args) {
        String[] seq = "{[()()][]([{}])}{{".split("");
        if (seq.length % 2 != 0){ //节约运算
            StdOut.print("    illegal  ");
            System.exit(0);
        }

        StackWithNodes<String> parenSeq = new StackWithNodes<String>();
        String popParen;
        for (String paren : seq) {
            StdOut.print(paren);

            if (paren.equals("{") || paren.equals("[") || paren.equals("(")) {
                parenSeq.push(paren);
            }

            if (!parenSeq.isEmpty()){
                if (paren.equals("}") && !"{".equals(parenSeq.pop())) {
                    StdOut.print("    illegal  ");
                    System.exit(0);
                }
                if (paren.equals(")") && !"(".equals(parenSeq.pop())) {
                    StdOut.print("    illegal   ");
                    System.exit(0);
                }
                if (paren.equals("]") && !"[".equals(parenSeq.pop())) {
                    StdOut.print("    illegal   ");
                    System.exit(0);
                }
            }
            else if (paren.equals("}") || paren.equals("]") || paren.equals(")")) {
                    StdOut.print("    illegal   ");
                    System.exit(0);
            }
        }
        if (!parenSeq.isEmpty()) StdOut.print("    illegal  ");
        else                     StdOut.print("    valid   ");
    }
}

class StackWithNodes<Item> implements Iterable<Item>{
    private Node first;
    private int N;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null;}

    public int size() { return N;}

    public void push(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek(){
        Item item = this.pop();
        this.push(item);
        return item;
    }

    public Iterator<Item> iterator() {return new StackIterator();}

    private class StackIterator implements Iterator<Item>
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
        StackWithNodes<String> s = new StackWithNodes<>();
//
//        while (!StdIn.isEmpty())
//        {
//            String item = StdIn.readString();
//            if (!item.equals("-")) s.push(item);
//            else if (!s.isEmpty()) StdOut.print(s.pop() + "");
//        }
//
//        StdOut.println("(" + s.size() + " left on stack)");
//
//        for (Object word:s) {
//            StdOut.println(word);
//        }


        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            s.push(item);
        }
        for (Object word:s) {
            StdOut.print(word + " ");
        }
        StdOut.println("Stack Test");
    }
}
