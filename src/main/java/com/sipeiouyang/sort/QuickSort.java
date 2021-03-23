package com.sipeiouyang.sort;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 快速排序
 */
public class QuickSort {

    public static int[] sort(int[] arr){
        if (arr == null){
            throw new RuntimeException("arr is null");
        }
        if (arr.length < 2){
            return arr;
        }
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int left, int right){
        if (left >= right){
            return;
        }
        int flag = arr[left];
        int index = left + 1;
        int end = right;
        while (index <= end){
            if (arr[index] <= flag){
                index++;
            }else {
                swap(arr, index, end);
                end--;
            }
        }
        index--;
        swap(arr, left, index);
        quickSort(arr, left, index - 1);
        quickSort(arr, index + 1, right);
    }


    private static void swap(int[] arr, int source, int obj){
        int cache = arr[source];
        arr[source] = arr[obj];
        arr[obj] = cache;
    }

}
