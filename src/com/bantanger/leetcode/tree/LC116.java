package com.bantanger.leetcode.tree;

import com.bantanger.linkedlist.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/13 15:25
 */
public class LC116 {
    class Solution_Recur {
        public Node connect(Node root) {
            if (root == null) return null;
            traverse(root.left, root.right);
            return root;
        }

        private void traverse(Node node1, Node node2) {
            if (node1 == null && node2 == null) return;
            node1.next = node2; // 传入节点连接
            // 递归左树的所有节点连成链表
            traverse(node1.left, node1.right);
            traverse(node2.left, node2.right);
            // 相隔节点相连
            traverse(node1.right, node2.left);
        }
    }

    class Solution_LevelOrder {
        public Node connect(Node root) {
            if(root == null) return null;
            Queue<Node> que = new LinkedList<>();
            que.offer(root);
            while(!que.isEmpty()) {
                int size = que.size();
                Node node = null;
                Node nodePre = null;
                for(int i = 0; i < size; i++) {
                    if(i == 0) {
                        nodePre = que.poll(); // 取出当前头节点
                        node = nodePre;
                    } else {
                        node = que.poll();
                        nodePre.next = node; // 前一个保存的节点与当前节点相连
                        nodePre = node; // 更新前节点
                    }
                    if(node.left != null) que.offer(node.left); // 左子树递归的执行前面的操作
                    if(node.right != null) que.offer(node.right); // 右子树递归的执行前面的操作
                }
                nodePre.next = null; // 没节点可连了，就将前节点置为null
            }
            return root;
        }
    }
}
