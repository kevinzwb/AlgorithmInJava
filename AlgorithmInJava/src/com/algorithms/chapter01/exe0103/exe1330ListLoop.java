package com.algorithms.chapter01.exe0103;

import edu.princeton.cs.algs4.StdOut;

public class exe1330ListLoop {

    public static void main(String[] args) {
        ListLoop<String> listLoop = new ListLoop<>();
        int N =26;
        int startIndex = 65;
        for (int i = 0; i < N; i++) {
            listLoop.addElement(IntToString(startIndex+i) + i);
        }
        StdOut.println(listLoop);
    }


    public static String IntToString(int num){
        char letter = (char)num;
        return String.valueOf(letter);
    }
}

class ListLoop<Item>{
    private Node<Item> last;

    public ListLoop() {
        last = new Node<>();
        last.item = null;
        last.next = last;
    }

    public void addElement(Item item){
        Node<Item> newNode = new Node<>();
        newNode.item = item;
        if (last.item == null){
            last.item = item;  newNode.item = item;
        }
        else{
            Node<Item> nextNode = last;
            while (nextNode.next != last){
                nextNode = nextNode.next;
            }
            newNode.next = last;
            nextNode.next = newNode;

        }

    }

    public void reverse(){
        Node<Item> firstNode  = last;
        Node<Item> secondNode = firstNode.next;
        Node<Item> thirdNode  = secondNode.next;


        while (thirdNode != last){
            secondNode.next = firstNode;
            firstNode = secondNode;
            secondNode = thirdNode;
            thirdNode = thirdNode.next;
        }
        secondNode.next = firstNode;
        last.next = secondNode;
        last = secondNode;
    }

    @Override
    public String toString() {
        Node<Item> nextNode = last;
        String NodeContent = "";
        while (nextNode.next != last) {
            NodeContent += nextNode.item+ " ";
            nextNode = nextNode.next;
        }
        NodeContent += nextNode.item+ " ";
        nextNode = nextNode.next;
        NodeContent += nextNode.item+ " ";
        return "ListLoop{ " + NodeContent + "}";
    }
}
