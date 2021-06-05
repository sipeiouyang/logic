package com.sipeiouyang.zcy.other;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 给定一个无序的整型数组 arr，找到其中最小的 k 个数。
 *
 *
 *
 *
 *
 */
public class TopKMin {

    public static void main(String[] args) {
        int[] arr = {1,3,4,7,8,9,9,9,9,9,43,2,4,6,4,4,5,6,7,7};
        int[] res = topK(arr, 9);
        for (int i: res
             ) {
            System.out.println(i);
        }
    }

    public static int[] topK(int[] arr, int k){
        if (k < 1 || k >= arr.length){
            return arr;
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = arr[i];
        }
        /**
         * 快排得到一个从大到小的数组
         **/
        fastSort(res, 0, k - 1);
        /**
         * 依次比较i = k+1到数组末尾，如果arr[i]>=res[0],直接忽略
         * 否则，将res[0] = arr[i]，然后调整res数组
         **/
        for (int i = k; i < arr.length; i++){
            if (arr[i] >= res[0]){
                continue;
            }
            res[0] = arr[i];
            adjustRes(res);
        }
        return res;
    }

    private static void adjustRes(int[] res){
        int i = 0;
        for (int j = 1; j < res.length; j++){
            if (res[i] >= res[j]){
                return;
            }
            swap(res, i, j);
            i = j;
        }
    }

    /**
     * 快排，从大到小
     **/
    public static void fastSort(int[] arr, int start, int end){
        if (start < 0 || end >= arr.length || start > end){
            return;
        }
        int flag = start;
        int left = start + 1;
        int right = end;
        while (left <= right){
            if (arr[left] >= arr[flag]){
                left++;
            }else {
                swap(arr, left, right);
                right--;
            }
        }
        left--;
        swap(arr, flag, left);
        fastSort(arr, start, left - 1);
        fastSort(arr, left + 1, end);
    }


    private static void swap(int[] arr, int i, int j){
        int cache = arr[i];
        arr[i] = arr[j];
        arr[j] = cache;
    }
}
