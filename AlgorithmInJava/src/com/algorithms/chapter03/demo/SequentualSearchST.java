package com.algorithms.chapter03.demo;

import com.sun.org.apache.xalan.internal.xsltc.dom.KeyIndex;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import java.util.Collection;
import java.util.Iterator;

public class SequentualSearchST<Key,Value> {
    private Node first;

    private class Node{
        Key key;
        Value val;
        Node next;

        public Node(Key key,Value val,Node next)
        {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    public Value get(Key key){
        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key))
                return x.val;
        return null;
    }

    public void put(Key key,Value val){
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key,val,first);
    }

    public boolean contains(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return true;
            }
        }
        return false;
    }

    public Iterable<Key> keys() {
        Stack<Key> stack = new Stack<>();
        for (Node x = first; x != null; x = x.next) {
            stack.push(x.key);
        }
        return stack;
    }

}
