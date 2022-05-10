package com.bantanger.leetcode.linkedlist;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/10 13:32
 */
public class LC19_reciprocal_K {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1, head), p = dummy;
            // 设置快慢指针，fast先走n步，slow不动，然后快慢指针同时移动，直到fast到达末尾
            ListNode fast, slow;
            fast = slow = p;
            while (n-- > 0) {
                fast = fast.next;
            }
            fast = fast.next;
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }
}
