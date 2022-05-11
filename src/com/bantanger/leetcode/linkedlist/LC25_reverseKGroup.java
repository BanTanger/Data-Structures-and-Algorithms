package com.bantanger.leetcode.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/11 8:55
 */
public class LC25_reverseKGroup {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) return head;
            ListNode a, b;
            a = b = head;
            // base case
            for(int i = 0; i < k; i++) {
                if (b == null) return head;
                b = b.next; // b指针移动。
                System.out.println(" " + k);
            }
            // 翻转k个一组的部分链表
            ListNode newhead = reverse(a, b);
            // 递归反转后续链表并连接起来
            a.next = reverseKGroup(b, k);
            return newhead;
        }

        public ListNode reverse(ListNode a, ListNode b) {
            ListNode cur = a, pre = null;
            while (cur != b) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }
    }

    @Test
    public void test(){
        ListNode p6 = new ListNode(1,null);
        ListNode p5 = new ListNode(1,p6);
        ListNode p4 = new ListNode(1,p5);
        ListNode p3 = new ListNode(1,p4);
        ListNode p2 = new ListNode(1,p3);
        ListNode p1 = new ListNode(1,p2);
        ListNode head = new ListNode(1,p1);
        new Solution().reverseKGroup(head,2);
    }
}
