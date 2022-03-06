package com.bantanger.linkedlist;


/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class SmallerEqualsBiggerQuestion {

    /**
     * 链表中的荷兰国旗问题
     * @param head 传入(虚)头节点
     * @param pivot 传入的划分值，根据pivot将链表划分为三个区域
     */
    public static Node SEBQ(Node head, int pivot){
        // 定义六个变量，小于部分的头节点和尾节点，大于部分的头尾，等于部分的头尾
        Node sH = null; Node sT = null;
        Node eH = null; Node eT = null;
        Node mH = null; Node mT = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = null;
            if (head.val < pivot){
                if (sH == null){
                    sH = head;
                    sT = head;
                }else{
                    sT.next = head; // 旧尾节点的下一个节点指向当前节点
                    sT = head; // 移动旧尾节点，当前节点作为新的尾节点
                }
            }else if(head.val == pivot){
                if (eH == null){
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null){
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }
        // 三个区域的头尾指针连接
        if (sT != null){ // 如果有小于区域
            sT.next = eH; // 肯定会存在eH（依据划分值来划分的范围，划分值就是eH）
            eT = eT == null ? sT : eT; // 但不一定有eT ，所以谁去连大于区域的头节点，谁就是eT
        }
        if (eT != null){ // 如果小于或等于区域至少有一个存在
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
    }
}
