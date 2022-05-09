package com.bantanger.leetcode.linkedlist;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/9 12:58
 */
public class LC21_merge {
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // 创建虚拟头节点，避免处理空指针情况，降低代码复杂性
            ListNode dummy = new ListNode(-1), p = dummy;
            ListNode p1 = list1, p2 = list2;
            while(p1 != null && p2 != null){
                // 比较p1,p2两个指针，将较小的那一个放在p指针后面
                if(p1.val > p2.val){
                    p.next = p2;
                    p2 = p2.next;
                } else {
                    p.next = p1;
                    p1 = p1.next;
                }
                p = p.next;
            }
            if (p1 != null) {
                p.next = p1;
            }
            if (p2 != null) {
                p.next = p2;
            }
            return dummy.next;
        }
    }
}
