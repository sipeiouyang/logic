package com.sipeiouyang.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 给定一个不含有重复值的数组 arr，找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置。返回所有位置相应的信息。
 *
 * arr = {3,4,1,5,6,2,7}返回如下二维数组作为结果:
 * {
 *  {-1, 2},
 *  { 0, 2},
 *  {-1,-1},
 *  { 2, 5},
 *  { 3, 5},
 *  { 2,-1},
 *  { 5,-1}
 * }
 * -1 表示不存在。
 *
 * 要求时间复杂度都达到 O(N)
 */
public class NearLessArr {

    /**
     * 使用单调栈达到时间复杂度O(N)
     **/
    public static int[][] getNearLessNoRepeat(int[] arr){
        if (Objects.isNull(arr) || arr.length < 1){
            return null;
        }
        int[][] result = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int cur = stack.pop();
                result[cur][0] = stack.isEmpty() ? -1 : stack.peek();
                result[cur][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int cur = stack.pop();
            result[cur][0] = stack.isEmpty() ? -1 : stack.peek();
            result[cur][1] = -1;
        }
        return result;
    }

    /**
     * 重复数组获取
     **/
    public static int[][] getNearLessRepeat(int[] arr){
        if (Objects.isNull(arr) || arr.length < 1){
            return null;
        }
        int[][] result = new int[arr.length][2];
        /**
         * 数组可能有重复的值，所以重复的值放到一个队列内
         **/
        Stack<LinkedList<Integer>> stacks = new Stack<>();
        for (int i = 0; i < arr.length; i++){
            while (!stacks.isEmpty() && arr[i] < arr[stacks.peek().getFirst()]){
                LinkedList<Integer> linkedList = stacks.pop();
                int leftIndex = stacks.isEmpty() ? -1 : stacks.peek().getLast();
                while (!linkedList.isEmpty()){
                    int index = linkedList.pop();
                    result[index][0] = leftIndex;
                    result[index][1] = i;
                }
            }
            if (!stacks.isEmpty() && arr[stacks.peek().getLast()] == arr[i]){
                stacks.peek().addLast(i);
            }
            LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.addLast(i);
            stacks.add(linkedList);
        }
        while (!stacks.isEmpty()){
            LinkedList<Integer> linkedList = stacks.pop();
            int rightIndex = -1;
            int leftIndex = stacks.isEmpty() ? -1 : stacks.peek().getLast();
            while (!linkedList.isEmpty()){
                int index = linkedList.pop();
                result[index][0] = leftIndex;
                result[index][1] = rightIndex;
            }
        }
        return result;
    }

}
