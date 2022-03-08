package com.bantanger.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class UniteOrderUnRecur {

    public static List<Integer> preOrderUnRecur(Node head) {
        List<Integer> result = new ArrayList<>();
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.peek(); // 取到栈顶元素，判断是否为空
                if (head != null) {
                    stack.pop(); // 弹出该栈元素，避免后面重复的操作
                    stack.push(head); // 中
                    stack.push(null);
                    // 中节点访问过，但还有没有添加到列表中收集处理，所以用空节点做记号
                    if (head.right != null) {   // 右
                        stack.push(head.right);
                    }
                    if (head.right != null) {   // 左
                        stack.push(head.left);
                    }
                } else { // 只有遇到空节点的时候才将下一个节点放到结果列表里
                    stack.pop(); // 直接将空节点弹出
                    head = stack.pop(); // 重新取出栈中元素
                    result.add(head.value);
                }
            }
        }
        return result;
    }

    public static List<Integer> inOrderUnRecur(Node head) {
        List<Integer> result = new ArrayList<>();
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.peek(); // 取到栈顶元素，判断是否为空
                if (head != null) {
                    stack.pop(); // 弹出该栈元素，避免后面重复的操作

                    if (head.right != null) {   // 右
                        stack.push(head.right);
                    }

                    stack.push(head); // 中
                    stack.push(null);
                    // 中节点访问过，但还有没有添加到列表中收集处理，所以用空节点做记号

                    if (head.right != null) {   // 左
                        stack.push(head.left);
                    }
                } else { // 只有遇到空节点的时候才将下一个节点放到结果列表里
                    stack.pop(); // 直接将空节点弹出
                    head = stack.pop(); // 重新取出栈中元素
                    result.add(head.value);
                }
            }
        }
        return result;
    }

    public static List<Integer> posOrderUnRecur(Node head) {
        List<Integer> result = new ArrayList<>();
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.peek(); // 取到栈顶元素，判断是否为空
                if (head != null) {
                    stack.pop(); // 弹出该栈元素，避免后面重复的操作

                    if (head.right != null) {   // 右
                        stack.push(head.right);
                    }
                    if (head.right != null) {   // 左
                        stack.push(head.left);
                    }
                    stack.push(head); // 中
                    stack.push(null);
                    // 中节点访问过，但还有没有添加到列表中收集处理，所以用空节点做记号

                } else { // 只有遇到空节点的时候才将下一个节点放到结果列表里
                    stack.pop(); // 直接将空节点弹出
                    head = stack.pop(); // 重新取出栈中元素
                    result.add(head.value);
                }
            }
        }
        return result;
    }
}
