package com.sipeiouyang.tree;

import com.sipeiouyang.tree.domain.Node;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 用递归和非递归方式，分别按照二叉树先序、中序和后序打印所有的节点。我们约定:先
 * 序遍历顺序为根、左、右;中序遍历顺序为左、根、右;后序遍历顺序为左、右、根。
 */
public class TreeTraverse {

    /**
     * 递归前序遍历
     **/
    public static List<Integer> preTraverseRecur(Node root){
        List<Integer> list = new LinkedList<>();
        preTraverseRecurSub(root, list);
        return list;
    }

    private static void preTraverseRecurSub(Node node, List<Integer> list){
        if (Objects.isNull(node)){
            return;
        }
        list.add(node.value);
        preTraverseRecurSub(node.left, list);
        preTraverseRecurSub(node.right, list);
    }

}
