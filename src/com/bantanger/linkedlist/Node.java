package com.bantanger.linkedlist;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class Node {
    public int val;
    public Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
