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

    public void removeAfter(Node<Item> node){
        if (node.item == null) ;
        else {
            Node next = first;
            for (int i = 0; next.next != null;i++) {
                if (next.item.equals(node.item)){
                    next.next = node;
                    N = i + 1;
                }
                next = next.next;
            }
        }
    }

    public void insetAfter(Node<Item> indexNode,Node<Item> insertNode){
        if (indexNode.item == null ||insertNode.item == null) ;
        else  {
            Node next = first;
            while (next.next != null){
                if (next.item.equals(indexNode.item)){
                    insertNode.next = next.next;
                    next.next = insertNode;
                    N++;
                    break;
                }
                next = next.next;
            }
        }
    }

    public void remove(String key){
        Node nextNode = first;
        Node previousNode = nextNode;
        while (nextNode.next != null) {
            if (nextNode.item.equals(key)) {
                previousNode.next = nextNode.next;
                N--;
            }
            previousNode = nextNode;
            nextNode = nextNode.next;

        }
    }





    private static int stringToInt(String letter){
        return (int)letter.charAt(0);
    }

    private static String IntToString(int num){
            char letter = (char)num;
            return String.valueOf(letter);
    }
}

class Node<Item>
{
    Item item;
    Node next;
}

