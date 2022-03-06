package com.bantanger.tree;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class OrderRecur {
    public static void preOrderRecur(Node head){
        if (head == null){
            return;
        }
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head){
        if (head == null){
            return;
        }
        preOrderRecur(head.left);
        System.out.println(head.value + " ");
        preOrderRecur(head.right);
    }

    public static void posOrderRecur(Node head){
        if (head == null){
            return;
        }
        preOrderRecur(head.left);
        preOrderRecur(head.right);
        System.out.println(head.value + " ");
    }
}
