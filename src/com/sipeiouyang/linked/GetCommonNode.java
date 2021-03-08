package com.sipeiouyang.linked;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 给定两个有序链表的头指针 head1 和 head2，打印两个链表的公共部分
 */
public class GetCommonNode {

    public List<Integer> getCommonNodet(Node head1, Node head2){
        LinkedList<Integer> resutl = new LinkedList<>();
        while (Objects.nonNull(head1) && Objects.nonNull(head2)){
            if (head1.value == head2.value){
                resutl.add(head1.value);
                head1 = head1.next;
                head2 = head2.next;
                continue;
            }
            if (head1.value < head2.value){
                head1 = head1.next;
                continue;
            }
            if (head1.value > head2.value){
                head2 = head2.next;
                continue;
            }
        }
        return resutl;
    }

}

class Node {
    public int value;
    public Node next;
    public Node(int data) {
        this.value = data;
    }
}
