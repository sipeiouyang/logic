package com.sipeiouyang.zcy.tree;

import com.sipeiouyang.zcy.tree.domain.Node;

import java.util.Objects;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 给定一个有序数组 sortArr，已知其中没有重复值，
 * 用这个有序数组生成一棵平衡搜索二叉 树，
 * 并且该搜索二叉树中序遍历的结果与 sortArr 一致。
 */
public class GenerateTreeByMidArr {

    public static Node getTree(int[] arr){
        if (Objects.isNull(arr) || arr.length < 1){
            return null;
        }
        return generate(arr, 0, arr.length - 1);
    }

    private static Node generate(int[] arr, int start, int end){
        if (start > end){
            return null;
        }
        int mid = (end - start) / 2 + start;
        Node head = new Node(arr[mid]);
        head.left = generate(arr, start, mid - 1);
        head.right = generate(arr, mid + 1, end);
        return head;
    }

}
