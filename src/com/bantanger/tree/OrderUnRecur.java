package com.bantanger.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class OrderUnRecur {

    /**
     * 宽度遍历:使用队列来，一层一层的从左往右遍历
     * @param head
     */
    public static void width(Node head){
        if (head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    /**
     * 前序遍历：准备一个栈，stack用来存放每一个遍历的节点，
     * 放入立马就弹出，先右后左
     * @param head
     */
    public static void preOrderUnRecur(Node head){
        System.out.println("pre-order:");
        if (head != null){
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value + " ");
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历:准备一个栈,对每颗子树而言。整棵树的左边界进栈,然后依次弹出，打印
     * 每弹出一次，检查是否有右树，如果有右树进栈,循环执行
     * @param head
     */
    public static void inOrderUnRecur(Node head){
        System.out.println("in-order:");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
        }
    }

    /**
     * 后序遍历：准备两个栈，s1用来存放头左右，然后每次在s1收集一个节点，
     * 就立刻弹出到s2中，最后等所有元素全部弹如s2中就打印s2所有
     * @param head 头节点
     */
    public static void posOrderUnRecur(Node head){
        System.out.println("pos-order:");
        if (head != null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            while(!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if (head.left != null){
                    s1.push(head.left);
                }
                if (head.right != null){
                    s1.push(head.right);
                }
            }
            while(!s2.isEmpty()){
                System.out.println(s2.pop().value + " ");
            }
        }
        System.out.println();
    }
}
