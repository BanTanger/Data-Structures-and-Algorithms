package com.bantanger.leetcode.linkedlist;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/10 16:35
 */
public class LC206_reverse {
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }
    }

    class Solution_Recur {
        public ListNode reverseList(ListNode head) {
            // 递归处理
            // 如果整个链表为空，或者只有head头节点自己，就直接返回head头节点
            if(head == null || head.next == null) return head;
            ListNode last = reverseList(head.next);
            head.next.next = head; // 让反转后的尾节点连接head节点
            head.next = null; // 让head节点的下一个节点连接null（head作为尾节点）
            return last; // last变成新链表的头节点
        }
    }
}
