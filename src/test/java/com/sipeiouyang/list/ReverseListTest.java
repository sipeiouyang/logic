package com.sipeiouyang.list;

import com.sipeiouyang.LogicTest;
import com.sipeiouyang.list.domain.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class ReverseListTest extends LogicTest {

    @Test
    public void test(){
        Node node = buildNode();
        node = ReverseList.reverseNode(node);
        int i = 4;
        while (Objects.nonNull(node)){
            Assert.assertEquals(i--, node.value);
            node = node.next;
        }
    }

    private Node buildNode(){
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        return node;
    }

}
