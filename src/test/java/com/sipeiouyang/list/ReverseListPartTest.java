package com.sipeiouyang.list;

import com.sipeiouyang.LogicTest;
import com.sipeiouyang.list.domain.Node;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class ReverseListPartTest extends LogicTest {

    @Test
    public void test(){
        Node node = buildNode();
        node = ReverseListPart.reverseList(node, 1, 5);
        for(int i = 5; i >= 1; i--){
            Assert.assertEquals(node.value, i);
            node = node.next;
        }
    }

    private Node buildNode(){
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        return node;
    }

}
