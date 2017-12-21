package com.algorithms.chapter01.exe0103;

import edu.princeton.cs.algs4.StdOut;

public class exe1320delete {
    public static void main(String[] args) {

        NodeList<String> ListTest = new NodeList<>(26);
        ListTest.display();
        StdOut.println();
        StdOut.println(find(ListTest,"B1"));
        StdOut.println(ListTest.find("B1"));
        ListTest.delete(1);
        StdOut.println();
        StdOut.println(ListTest.find("B1"));
        ListTest.display();
        StdOut.println();
        StdOut.println(find(ListTest,"B1"));



    }

    public static boolean find(NodeList<String> listBox,String key){
        return listBox.find(key);
    }
}
