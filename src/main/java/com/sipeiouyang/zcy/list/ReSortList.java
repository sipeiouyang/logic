package com.sipeiouyang.zcy.list;

import com.sipeiouyang.zcy.list.domain.ListNode;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 重排单向链表
 *
 * 描述
 * 给定一个单链表L: L0→L1→…→Ln-1→Ln,
 *
 * 重新排列后为：L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 必须在不改变节点值的情况下进行原地操作。
 */
public class ReSortList {
    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode last = getLastAndRemoveLast(head);
        last.next = head.next;
        head.next = last;
        reorderList(last.next);
    }

    /**
     * 获取链表最后节点，并移除最后节点
     **/
    private ListNode getLastAndRemoveLast(ListNode head){
        if (head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode index = head.next;
        while (index.next != null){
            pre = pre.next;
            index = index.next;
        }
        pre.next = null;
        return index;
    }
}
