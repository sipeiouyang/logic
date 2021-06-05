package com.sipeiouyang.zcy.tree;

import java.util.Objects;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 给定一个整型数组 arr，已知其中没有重复值，
 * 判断 arr 是否可能是节点值类型为整型的搜 索二叉树后序遍历的结果。
 */
public class CheckThePostArr {

    /**
     * 后续遍历，说明最后一个节点是根节点，
     * 根据搜索二叉树的性质，比后序数组最后一个元素值小的数组会在数组的左边，
     * 比数组最后一个元素值大的数组会在数组的右边,并且这两个数组的区间一定是紧挨着的
     **/
    public static boolean check(int[] arr){
        if (Objects.isNull(arr) || arr.length == 0) {
            return false;
        }
        return check(arr, 0, arr.length - 1);
    }


    private static boolean check(int[] arr, int start, int end){
        if (start == end){
            return true;
        }
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
        if (min == -1 || max == end){
            //表示该搜索树只有一边
            return check(arr, 0, end - 1);
        }
        if (min != (max - 1)){
            return false;
        }
        return check(arr, 0, min) && check(arr, max, end - 1);
    }
}
