package com.algorithms.chapter01.exe0103;

import edu.princeton.cs.algs4.StdOut;

public class exe1319Nodes {
    public static void main(String[] args) {


        NodeList<String> ListTest = new NodeList<>(26);
        ListTest.display();



    }
}

class NodeList<Item>{
    private Node first;
    private Node last ;
    private int N;

    private class Node<Item>
    {
        Item item;
        Node next;
    }

//    public NodeList(int n) {
//        int startIndex = 65;
//        N = n;
//        for (int i = startIndex; i < (startIndex + N); i++) {
//            Node oldfirst = first;
//            first = new Node();
//            first.item = IntToString(i);
//            first.next = oldfirst;
//        }
//    }

    public NodeList(int n) {
        N = n;
        int startIndex = 65;
        for (int i = 0; i < N; i++) {
            Node oldlast = last;
            last = new Node();
            last.item = IntToString(startIndex+i) + i;
            last.next = null;
            if (i == 0) first = last;
            else oldlast.next = last;
        }
    }


    public void display(){
        Node next = first;
        for (int i = 0; i < N ; i++) {
            StdOut.print(next.item + " ");
            next = next.next;
        }
    }

    public void delete(int k){
        if (k == 0)
            first = first.next;
        else{
            Node next = first;
            for (int i = 1; i < k; i++) {
                next = next.next;
            }
            StdOut.print(next.next.item + " ");

            Node deleteNode = next.next;
            next.next = deleteNode.next;
        }
        N--;
    }

    public boolean find(String key){
        Node next = first;
        while (next.next != null){
            if (next.item.equals(key)) return true;
            next = next.next;
        }
        return false;
    }


    private static int stringToInt(String letter){
        return (int)letter.charAt(0);
    }

    private static String IntToString(int num){
            char letter = (char)num;
            return String.valueOf(letter);
    }
}
