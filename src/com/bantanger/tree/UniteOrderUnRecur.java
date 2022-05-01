package com.bantanger.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class UniteOrderUnRecur {

    public static List<Integer> preOrderUnRecurTest(Node head){
        List<Integer> res = new ArrayList<>();
        if(head == null) return res; // 终止条件，遍历到叶子节点结束当前遍历

        Stack<Node> st = new Stack<>();
        st.push(head); // 头节点特殊处理压入栈中
        while(!st.isEmpty()){ // 每一层的所有元素先右再左压入栈中，然后依次弹出得到前序数组
            head = st.peek(); // head的设置是为了检查当前栈顶是否为null
            if(head != null){ // 栈顶 !null 才能执行 访问 操作
                st.pop(); // 弹出head，避免 之后的'中'过程 的重复入栈操作

                // 注意栈方法进行前序遍历需要先右后左！！！
                if(head.right != null) st.push(head.right); // 右
                st.push(head); // 中
                st.push(null); // 中节点访问过，但还没有添加到列表中进行处理，所以用空节点标记
                if(head.left != null) st.push(head.left); // 左
            } else { // 栈顶为 null 才能执行 处理 操作
                st.pop(); // 先将空节点弹出
                head = st.peek(); // 取出栈中元素 （此时一定不是空节点，因为空节点不会连续）
                res.add(head.value); // 将元素放入列表，得到前序遍历数组
            }
        }
        return res;
    }

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
