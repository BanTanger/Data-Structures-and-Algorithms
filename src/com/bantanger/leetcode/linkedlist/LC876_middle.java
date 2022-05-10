package com.bantanger.leetcode.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/10 14:33
 */
public class LC876_middle {
    class Solution {
        public ListNode middleNode(ListNode head) {
            int count = 0;
            ListNode p = head;
            while(p != null){
                count++;
                p = p.next;
            }
            int k = 0;
            p = head;
            while(count % 2 == 0 && k < count / 2) {
                p = p.next;
                k++;
                System.out.println(k);
            }
            while(count % 2 == 1 && k < count / 2) {
                k++;
                p = p.next;
                System.out.println(k);
            }
            return p;
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
        new Solution().middleNode(head);
    }
}
