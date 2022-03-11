package com.bantanger.tree;

import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class Node {
    public int value;
    public Node left;
    public Node right;
    public List<Node> children;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
