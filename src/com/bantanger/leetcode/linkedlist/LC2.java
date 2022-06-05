package com.bantanger.leetcode.linkedlist;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/5 21:16
 */
public class LC2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p1 = l1, p2 = l2;
            // 创建虚拟头节点
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            // 记录进位
            int carry = 0;
            // 执行加法，两条链表走完并且没有进位才能结束循环
            while(p1 != null || p2 != null || carry != 0) {
                // 上次进位的值
                int val = carry;
                if(p1 != null) {
                    val += p1.val;
                    p1 = p1.next;
                }
                if(p2 != null) {
                    val += p2.val;
                    p2 = p2.next;
                }
                // 处理进位情况
                carry = val / 10;
                val = val % 10;
                // 构建新节点
                p.next = new ListNode(val);
                p = p.next;
            }
            return dummy.next;
        }
    }
}
