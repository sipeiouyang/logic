package com.sipeiouyang.zcy.list;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 生成窗口最大值数组
 *
 * 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边，窗口每次向右边 滑一个位置。
 * 例如，数组为[4,3,5,4,3,3,6,7]，窗口大小为 3 时:
 * [4 3 5] 4 3 3 6 7
 * 4 [3 5 4] 3 3 6 7
 * 4 3 [5 4 3] 3 6 7
 * 4 3 5 [4 3 3] 6 7
 * 4 3 5 4 [3 3 6] 7
 * 4 3 5 4 3 [3 6 7]
 * 窗口中最大值为 5 窗口中最大值为 5 窗口中最大值为 5 窗口中最大值为 4 窗口中最大值为 6 窗口中最大值为 7
 * record[0] = nowAct;
 * 如果数组长度为 n，窗口大小为 w，则一共产生 n-w+1 个窗口的最大值。 请实现一个函数。
 * 1.输入:整型数组arr，窗口大小为w。
 * 2.输出:一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。
 * 以本题为例，结果应该返回{5,5,5,4,6,7}。
 */
public class MaxWindow {


    public static int[] getMaxWindow(int[] arr, int w){
        if (Objects.isNull(arr) || w < 1 || w > arr.length){
            return null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[arr.length - w + 1];
        for (int i = 0; i < arr.length; i++){
            while (!queue.isEmpty() && arr[queue.peekLast()] < arr[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            if (i - queue.peekFirst() == w){
                queue.pollFirst();
            }
            if (i - w >= -1){
                result[i - w + 1] = arr[queue.peekFirst()];
            }
        }
        return result;
    }
}
