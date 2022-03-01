package com.bantanger.linkedlist;

import java.util.Stack;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "林冲", "豹子头");
        HeroNode heroNode4 = new HeroNode(4, "吴用", "智多星");

//        创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
       /* singleLinkedList.add(heroNode);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);*/

        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);

        singleLinkedList.show();

        System.out.println("====================");

        HeroNode heroNode1 = new HeroNode(2, "张飞", "莽夫");

        singleLinkedList.update(heroNode1);
        singleLinkedList.delete(3);

        singleLinkedList.show();
        System.out.println("=======");
        HeroNode node = singleLinkedList.getNode(3);
        System.out.println(node);
    }
}

class SingleLinkedList {
    // 初始化头节点
    private HeroNode head = new HeroNode(0, "", "");

    // 增添 add 无序插入
    public void add(HeroNode heroNode) {
        // 先将头节点赋给一个变量来遍历
        HeroNode temp = head;
        while (true) {
            // 尾插，遍历到链表末尾
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // 经过while循环现在temp指针已经指向了最后的节点
        temp.next = heroNode;
    }

    // 增添 addByOrder 有序插入
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false; // flag 标志表示要添加的元素是否存在，默认为false不存在
        // 遍历寻找想要插入的编号位置
        while (true) {
            if (temp.next == null) {
                break; // temp 已经是最末尾了
            }
            if (temp.next.No > heroNode.No) { // 找到位置，就在temp的后面插入heroNode
                break;
            } else if (temp.next.No == heroNode.No) {
                flag = true; // 要插入数据的编号存在，无法插入
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            // 不能插入，编号存在
            System.out.println("编号" + heroNode.No + "已经存在，不能添加该元素");
        } else {
            heroNode.next = temp.next; // 断开temp与原先temp.next的联系，让heroNode与temp.next链接
            temp.next = heroNode; // temp的后一个位置插入heronext
        }
    }

    // 修改节点信息，根据No编号来进行修改，所以No编号是不可改变的
    public void update(HeroNode heroNode) {
        // 判空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 找到要修改的节点，通过No来查找
        // 设置辅助变量
        boolean flag = false; // 是否找到该节点
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.No == heroNode.No) {
                flag = true; // 找到元素，flag转换为true
                break;
            }
            temp = temp.next;
        }
        if (flag == true) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        } else {
            System.out.println("不存在该编号，没有找到" + heroNode.No);
        }
    }

    public void delete(int No) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.No == No) { // 找到要删除节点的前一个位置
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 判断flag
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到该元素，无法删除");
        }
    }

    // 方法：获得到单链表的节点个数（如果带头节点，需求不统计头节点）

    /**
     * @param head 传入链表的头节点
     * @return 返回有效节点个数
     */
    public static int getlength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    // 查找单链表中的倒数第k个节点【新浪】

    /**
     * @param k k代表单链表中倒数第k个节点位置
     * @return 返回k位置的整个节点
     * <p>
     * 思路分析:快慢指针，让快指针fastIndex向前走 k 步之后暂停，
     * 然后让慢指针和快指针一起移动，直到快指针走向尾部，此时慢指针就是倒数k位
     */
    public HeroNode getNode(int k) {
        // 先判空
        if (head.next == null) {
            throw new RuntimeException("链表为空，不能获取任何节点");
        }
        // 设置快慢指针
        HeroNode fastIndex, slowIndex;
        fastIndex = slowIndex = head.next;
        // 设置一个计数变量
        int count = 0;
        while (fastIndex != null && slowIndex != null) {
            if (count < k) {
                fastIndex = fastIndex.next;
                count++;
            }
            if (count == k && fastIndex != null) {
                fastIndex = fastIndex.next;
                slowIndex = slowIndex.next;
            }
        }
        return slowIndex;
    }

    // 单链表的翻转【腾讯】
    public HeroNode reverse() {
        // 判空
        if (head.next == null) {
            throw new RuntimeException("链表为空");
        }
        // 创建双指针。
        HeroNode cur = head;
        HeroNode pre = null;
        while (cur != null) {
            // 创建临时变量先保存节点
            HeroNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp; // 相当于前指针移动
        }
        return pre;
        // 此时pre位于前链表的最后位置，新链表的head位置，返回pre就能得到新链表整体
    }

    // 从尾到头打印单链表【百度】使用栈stack方式
    public void reversePrint() {
        // 判空
        if (head.next == null) {
            return;
        }
        // 遍历链表并将数据压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 将栈中的节点进行打印，pop出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop()); // stack特点先进后出
        }
    }

    // show 展示链表
    public void show() {
        // 先判空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 遍历链表
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode {
    public int No; // 编号
    public String name;
    public String nickname;
    public HeroNode next; // 指向下一个节点

    public HeroNode(int No, String name, String nickname) {
        this.No = No;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "No=" + No +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

