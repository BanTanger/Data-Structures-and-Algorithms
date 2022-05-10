package com.bantanger.leetcode.linkedlist;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/10 16:56
 */
public class LCxxx_reverseN {
    class Solution {
        ListNode successor = null; // 使用后驱节点记录不反转的链表部分

        /**
         *  反转以head 为起点的n个节点，返回新的头节点
         */
        ListNode reverseN(ListNode head, int n) {
            if (n == 1) {
                // 记录第 n + 1个节点
                successor = head.next;
                return head;
            }
            // 以 head.next 为起点，需要反转前 n - 1 个节点
            ListNode last = reverseN(head.next, n - 1);

            head.next.next = head;
            head.next = successor;
            return last;
        }
    }
}
