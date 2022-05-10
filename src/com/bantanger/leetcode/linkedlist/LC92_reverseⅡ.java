package com.bantanger.leetcode.linkedlist;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/10 18:56
 */
public class LC92_reverseⅡ {
    class Solution {
        ListNode successor = null;

        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == 1) {
                return reverseN(head, right);
            }
            // 让不需要反转的最后一个结点的next指针指向已经逆转并返回的头结点，不然链表会断
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }

        public ListNode reverseN(ListNode head, int n) {
            if (n == 1) {
                successor = head.next;
                return head;
            }
            ListNode last = reverseN(head.next, n - 1);
            head.next.next = head;
            head.next = successor;
            return last;
        }
    }
}
