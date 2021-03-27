package com.sipeiouyang.list;

import com.sipeiouyang.list.domain.DoubleNode;
import com.sipeiouyang.list.domain.Node;

import java.util.Objects;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 分别实现反转单向链表和反转双向链表的函数。
 *
 * 如果链表长度为 N，时间复杂度要求为 O(N)，额外空间复杂度要求为 O(1)。
 *
 */
public class ReverseList {

    public static Node reverseNode(Node head){
        Node pre = null;
        Node next = null;
        while (Objects.nonNull(head)){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static DoubleNode reverseNode(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (Objects.nonNull(head)){
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

}
