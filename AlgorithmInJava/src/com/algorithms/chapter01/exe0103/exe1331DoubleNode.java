package com.algorithms.chapter01.exe0103;

import edu.princeton.cs.algs4.StdOut;

public class exe1331DoubleNode {
    public static void main(String[] args) {
        DoubleList test = new DoubleList();
        test.addBefore(5);
        test.addBefore(4);
        test.addBefore(3);
        test.addBefore(2);
        test.addBefore(1);
        test.addBefore(0);
        StdOut.println(test);

        test.addAfter(6);
        test.addAfter(7);
        test.addAfter(8);
        test.addAfter(9);
        test.addAfter(10);
        StdOut.println(test);

        test = new DoubleList();
        test.addBefore(5);
        test.addAfter(6);
        test.addBefore(4);
        test.addBefore(3);
        test.addBefore(2);
        test.addAfter(7);
        StdOut.println(test);

        test.deleteAfter();
        test.deleteBefore();
        StdOut.println(test);

        test.insertafter(5,1);
        test.insertBefore(5,1);
        StdOut.println(test);

        test.delete(1);
        StdOut.println(test);

    }
}


class DoubleList<Item>{
    private DoubleNode<Item> head = new DoubleNode<>();
    private DoubleNode<Item> tail = new DoubleNode<>();

    private class DoubleNode<Item>{
        Item item;
        DoubleNode previous;
        DoubleNode next;
    }

    public void addBefore(Item item) {
        if (head.item == null) {
            head.item = item;
            tail.item = head.item;
        }
        else {
            DoubleNode oldhead = head;
            head = new DoubleNode();
            head.item = item;
            head.next = oldhead;
            oldhead.previous = head;
            if (head.next.item.equals(tail.item)) {
                head.next = tail;
                tail.previous = head;
            }
        }
    }


    public void addAfter(Item item){
        if (tail.item == null){
            tail.item = item;
            head.item = tail.item;
        }
        else {
            DoubleNode oldtail = tail;
            tail = new DoubleNode();
            tail.item = item;
            tail.previous = oldtail;
            oldtail.next = tail;
            if (tail.previous.item.equals(head.item)){
                head.next = tail;
                tail.previous = head;
            }
        }
    }

    public void deleteAfter(){
        tail = tail.previous;
        tail.next = null;
    }

    public void deleteBefore(){
        head = head.next;
        head.previous = null;
    }

    public void insertBefore(Item index,Item item){
        DoubleNode nextNode = head;
        if (head.item.equals(index)) addBefore(item);
        else {
            while(nextNode.next != null){
                if (nextNode.item.equals(index)){
                    DoubleNode insertNode = new DoubleNode();
                    DoubleNode oldPreviousNode = nextNode.previous;
                    insertNode.item = item;
                    insertNode.previous = nextNode.previous;
                    insertNode.next = nextNode;
                    nextNode.previous = insertNode;
                    oldPreviousNode.next = insertNode;
                    break;
                }
                nextNode = nextNode.next;
            }
        }
    }

    public void insertafter(Item index,Item item){
        DoubleNode previousNode = tail;
        if (previousNode.item.equals(index)) addAfter(item);
        else {
            while(previousNode.previous != null){
                if (previousNode.item.equals(index)){
                    DoubleNode insertNode = new DoubleNode();
                    DoubleNode oldNextNode = previousNode.next;
                    insertNode.item = item;
                    insertNode.next = previousNode.next;
                    insertNode.previous = previousNode;
                    previousNode.next = insertNode;
                    oldNextNode.previous = insertNode;
                    break;
                }
                previousNode = previousNode.previous;
            }
        }
    }

    public void delete(Item item){
        DoubleNode nextNode = head;
        if (tail.item.equals(item)) deleteBefore();
        while(nextNode != null){
            if (nextNode.item.equals(item)){
                DoubleNode previousNextNode = nextNode.previous;
                DoubleNode nextNextNode = nextNode.next;
                previousNextNode.next = nextNextNode;
                nextNextNode.previous = previousNextNode.next;
            }
            nextNode = nextNode.next;
        }
    }


    @Override
    public String toString() {
        DoubleNode<Item> nextNode = head;
        String NodeContent = "";
        while (nextNode != tail.next) {
            NodeContent += nextNode.item+ " ";
            nextNode = nextNode.next;
        }
        return "ListLoop{ " + NodeContent + "}";
    }
}
