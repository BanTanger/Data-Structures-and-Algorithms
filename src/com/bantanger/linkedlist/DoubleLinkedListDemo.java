package com.bantanger.linkedlist;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表测试");
        ListNode listNode = new ListNode(1, 13);
        ListNode listNode1 = new ListNode(2, 45);
        ListNode listNode2 = new ListNode(3, 12);
        ListNode listNode3 = new ListNode(4, 5);

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(listNode);
        doubleLinkedList.add(listNode2);
        doubleLinkedList.add(listNode3);
        doubleLinkedList.add(listNode1);

        doubleLinkedList.show();

        System.out.println("=====================");
        // 修改
        ListNode listNode4 = new ListNode(2, 100);
        doubleLinkedList.update(2, listNode4);

        doubleLinkedList.show();
        System.out.println("=====================");

        // 删除
        doubleLinkedList.delete(3);

        doubleLinkedList.show();

        System.out.println("=====================");
        ListNode listNode5 = new ListNode(4, 45);
        ListNode listNode6 = new ListNode(3, 45);
        doubleLinkedList.addByOrder(listNode5);
        doubleLinkedList.addByOrder(listNode6 );
        doubleLinkedList.show();
    }
}

class DoubleLinkedList {
    // 初始化头节点，头节点不要用，不存放具体值
    private ListNode head = new ListNode(-1, 0);

    public ListNode getHead() {
        return head;
    }

    // 尾插
    public void add(ListNode listNode) {
        ListNode temp = head; // 指向头节点，因为头节点不能移动
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = listNode;
        listNode.pre = temp;
    }

    // 按编号插入
    public void addByOrder(ListNode listNode) {
        ListNode temp = head;
        boolean flag = false; // 标志要添加的元素是否存在，默认false表示不存在
        while (temp.next != null) {
            if (temp.index == listNode.index) {
                flag = true; // 要插入的数据存在，无法插入
                break;
            } else if (temp.next.index > listNode.index){
                break; // 找到位置，就在temp后面插入liseNode
            }
            temp = temp.next;
        }
        if (flag == true) {
            System.out.println("要插入的编号存在，无法插入");
        } else if (temp.next != null && flag == false){
            listNode.next = temp.next;
            temp.next = listNode;
            listNode.pre = temp;
            listNode.next.pre = listNode;
        } else{
            // temp.next == null
            temp.next = listNode;
            listNode.next = null;
            listNode.pre = temp;
        }
    }

    // 修改
    public void update(int index, ListNode listNode) {
        // 先判空
        if (head.next == null) {
            return;
        }
        ListNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.index == listNode.index) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag == true) {
            temp.val = listNode.val;
        } else {
            System.out.println("不存在该编号，无法修改");
        }
    }

    // 删除
    public void delete(int index) {
        if (head.next == null) {
            return;
        }
        ListNode temp = head.next;
        boolean flag = false;
        while (temp != null) {
            if (temp.index == index) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag == true) {
            temp.pre.next = temp.next;
            // 如果是最后一个节点就不要执行下面这句话
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("不存在该编号，删除失败");
        }
    }

    // 遍历双向链表
    public void show() {
        // 先判空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 遍历链表
        ListNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class ListNode {
    public int val; // 值
    public int index;
    public ListNode pre; // 指向前一个节点，默认为null
    public ListNode next; // 指向后一个节点，默认为null

    public ListNode(int index, int val) {
        this.index = index;
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", index=" + index +
                '}';
    }
}
