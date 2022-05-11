package com.bantanger.leetcode.linkedlist;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/11 23:38
 */
public class LC234_palindrome {
    ListNode left = null;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    public boolean traverse(ListNode right) {
        if(right == null) return true;
        boolean res = traverse(right.next);
        // 后序遍历代码，根据递归特性，目前right已经前进到尾节点。
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }
}
