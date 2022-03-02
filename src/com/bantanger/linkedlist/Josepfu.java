package com.bantanger.linkedlist;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList csll = new CircleSingleLinkedList();
        csll.addBoy(25);
        csll.showBoy();

        csll.countBoy(1,2,25);
    }
}

class CircleSingleLinkedList {
    // 创建一个first节点，当前没有编号
    private Boy first = null;
    private Boy curBoy = null;

    public void addBoy(int nums) {
        // 对nums进行数据校验，不能传入小于 1 的数
        if (nums < 1) {
            System.out.println("不能传入小于 1 的数");
            return;
        }

        // 创建环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);// 根据编号，创建小孩节点
            // 如果是第一个小孩，情况比较特殊
            if (i == 1) {
                first = boy;
                boy.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    // 遍历当前环形链表
    public void showBoy() {
        // 先判空
        if (first == null) {
            System.out.println("没有任何人");
            return;
        }
        // 因为first不能移动，所以通过设置一个临时变量来完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.println("小孩的编号为 " + curBoy.getIndex());
            if (curBoy.getNext() == first) { // 已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * @param startNo  表示从第几个小孩开始数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少个小孩在圈中
     */
    // 根据用户输入，计算出小孩出圈顺序
    public void countBoy(int startNo, int countNum, int nums) {
        // 无效数据校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("输入有误，请重新计数");
            return;
        }
        Boy helper = first;
        // 需求创建一个辅助指针变量helper，遍历helper指向环形链表最后的节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        // 小孩报数前，先让first和helper移动 k - 1次，（first一开始是0位，要达到 k 位需要移动 k -1 次）
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while(true){
            // 如果只有一个小孩的情况，直接让他返回
            if (first == helper){
                break;
            }
            // first 和 helper 同时移动countNum - 1次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // first当前指向的节点就是要出圈的节点
            System.out.println("小孩" + first.getIndex() + "出圈");
            // 将first向前移动一位，让helper的下一个节点指向新的first，实现删除first
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈内的小孩是 " + helper.getIndex());
    }
}

class Boy {
    private int index;
    private Boy next;

    public Boy(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    @Override
    public String toString() {
        return "Boy{" +
                "index=" + index +
                ", next=" + next +
                '}';
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}