package com.sipeiouyang.tree;

import com.sipeiouyang.tree.domain.Node;

import java.util.Objects;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 给定一个整型数组 arr，已知其中没有重复值，
 * 已知其是一棵搜索二叉树的后序遍历结果， 通过数组 arr 重构二叉树。
 */
public class GenerateTreeByPostArr {

    public static Node generateTree(int[] arr){
        if (Objects.isNull(arr) || arr.length < 1){
            return null;
        }
        return generateTree(arr, 0, arr.length - 1);
    }

    private static Node generateTree(int[] arr, int start, int end){
        if (start > end) {
            return null;
        }
        Node root = new Node(arr[end]);
        int rootValue = arr[end];
        int min = -1;
        int max = end;
        for (int i = start; i < end; i++){
            if (arr[i] < rootValue){
                min = i;
                continue;
            }
            max = max == end ? i : max;
        }
        root.left = generateTree(arr, start, min);
        root.right = generateTree(arr, max, end - 1);
        return root;
    }

}
