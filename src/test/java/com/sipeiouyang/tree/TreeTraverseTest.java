package com.sipeiouyang.tree;

import com.sipeiouyang.LogicTest;
import com.sipeiouyang.tree.domain.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class TreeTraverseTest extends LogicTest {

    @Test
    public void test(){
        Node node = buildTree();
        int num = 1;
        List<Integer> list = TreeTraverse.preTraverseRecur(node);
        for (int i : list){
            System.out.println(i);
        }
    }


    private Node buildTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = null;
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        return root;
    }

}
