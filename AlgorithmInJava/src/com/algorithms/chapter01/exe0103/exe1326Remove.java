package com.algorithms.chapter01.exe0103;

import edu.princeton.cs.algs4.StdOut;

public class exe1326Remove {
    public static void main(String[] args) {
        NodeList<String> ListTest = new NodeList<>(26);
        ListTest.display();
        StdOut.println();
        Node<String> node1 = new Node<>();
        node1.item = "L11";
        Node<String> node2 = new Node<>();
        node2.item = "ZWB";
        ListTest.insetAfter(node1,node2);
        ListTest.display();
        StdOut.println();
        node1.item = "Q16";
        node2 = new Node<>();
        node2.item = "ZWB";
        ListTest.insetAfter(node1,node2);
        ListTest.display();
        StdOut.println();
        node1.item = "X23";
        node2 = new Node<>();
        node2.item = "ZWB";
        ListTest.insetAfter(node1,node2);
        ListTest.display();
        StdOut.println();
        ListTest.remove("ZWB");
        ListTest.display();
        StdOut.println();

    }

}





