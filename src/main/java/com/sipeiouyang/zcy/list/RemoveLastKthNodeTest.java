package com.sipeiouyang.zcy.list;

import com.sipeiouyang.LogicTest;
import com.sipeiouyang.zcy.list.domain.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class RemoveLastKthNodeTest extends LogicTest {

    @Test
    public void test(){
        Node head = build();
        head = RemoveLastKthNode.removeLastKthNode(head, 1);
        int i = 1;
        while (Objects.nonNull(head)){
            Assert.assertEquals(i++, head.value);
            head = head.next;
        }
        head = build();
        head = RemoveLastKthNode.removeLastKthNode(head, 2);
        Assert.assertEquals(head.value, 1);
        head = head.next;
        Assert.assertEquals(head.value, 2);
        head = head.next;
        Assert.assertEquals(head.value, 4);
    }

    private Node build(){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        return head;
    }

}
