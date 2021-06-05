package com.sipeiouyang.zcy.list;

import com.sipeiouyang.zcy.list.domain.DoubleNode;
import com.sipeiouyang.zcy.list.domain.Node;

import java.util.Objects;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 在单链表和双链表中删除倒数第 K 个节点
 *
 * 【题目】
 * 分别实现两个函数，一个可以删除单链表中倒数第 K 个节点，另一个可以删除双链表中倒 数第 K 个节点。
 * 【要求】
 * 如果链表长度为 N，时间复杂度达到 O(N)，额外空间复杂度达到 O(1)。
 *
 */
public class RemoveLastKthNode {

    /**
     * 单链表
     **/
    public static Node removeLastKthNode(Node node, int k){
        if (Objects.isNull(node) || k < 1){
            return node;
        }
        Node indexNode = node;
        int indexNum = k;
        while (Objects.nonNull(indexNode)){
            indexNum--;
            indexNode = indexNode.next;
        }
        /**
         * 此时indexNum的值为k-sizeOf(node)
         **/
        if (indexNum == 0){
            return node.next;
        }
        if (indexNum > 0){
            return node;
        }
        /**
         * 找出要删除的前一个节点
         **/
        indexNode = node;
        while (++indexNum != 0){
            indexNode = indexNode.next;
        }
        indexNode.next = indexNode.next.next;
        return node;
    }

    /**
     * 双链表
     **/
    public static DoubleNode removeLastKthNode(DoubleNode head, int k){
        if (Objects.isNull(head) || k < 1){
            return head;
        }
        DoubleNode cur = head;
        int num = k;
        while (Objects.nonNull(cur)){
            num--;
            cur = cur.next;
        }
        if (num > 0){
            return head;
        }
        if (num == 0){
            head = head.next;
            head.pre = null;
            return head;
        }
        cur = head;
        while (++num != 0){
            cur = cur.next;
        }
        DoubleNode cache = cur.next.next;
        cur.next = cache;
        if (Objects.nonNull(cache)){
            cache.pre = cur;
        }
        return head;
    }



}
