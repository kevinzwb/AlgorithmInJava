package com.algorithms.chapter01.exe0103;

import edu.princeton.cs.algs4.StdOut;

public class exe1324RemoveAfter {
    public static void main(String[] args) {
        NodeList<String> ListTest = new NodeList<>(26);
        ListTest.display();
        StdOut.println();
        Node<String> node = new Node<>();
        node.item = "L11";
        node.next = null;
        ListTest.removeAfter(node);
        ListTest.display();
        StdOut.println();
    }

}





