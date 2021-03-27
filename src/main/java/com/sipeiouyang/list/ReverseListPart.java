package com.sipeiouyang.list;

import com.sipeiouyang.list.domain.Node;

import java.util.Objects;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 反转部分单向链表
 *
 * 给定一个单向链表的头节点 head，以及两个整数 from 和 to，
 * 在单向链表上把第 from 个节 点到第 to 个节点这一部分进行反转。
 *
 * 1.如果链表长度为 N，时间复杂度要求为 O(N)，额外空间复杂度要求为 O(1)
 * 2.如果不满足 1<=from<=to<=N，则不用调整。
 */
public class ReverseListPart {

    /**
     * 反转部分链表，找到form-1、to+1节点，然后将这两个节点之间链表进行反转
     * 最后将这部分链表，与前后两个节点相连
     **/
    public static Node reverseList(Node head, int from, int to){
        if (Objects.isNull(head)){
            return head;
        }
        int len = 0;
        Node cur = head;
        Node fromPre = null;
        Node toNext = null;
        while (Objects.nonNull(cur)){
            len++;
            fromPre = ((len + 1) == from) ? cur : fromPre;
            toNext = ((len - 1) == to) ? cur : toNext;
            cur = cur.next;
        }
        if (from < 1 || to < from || to > len){
            return head;
        }
        /**
         * 开始反转链表区间
         **/
        Node moveNode1 = Objects.isNull(fromPre) ? head : fromPre.next;
        Node moveNode2 = moveNode1.next;
        moveNode1.next = toNext;
        Node moveNode3 = null;
        while (moveNode2 != toNext){
            moveNode3 = moveNode2.next;
            moveNode2.next = moveNode1;
            moveNode1 = moveNode2;
            moveNode2 = moveNode3;
        }
        if (Objects.isNull(fromPre)){
            return moveNode1;
        }
        fromPre.next = moveNode1;
        return head;
    }

}
