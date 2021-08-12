package com.sipeiouyang.CodingInterviews;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 只出现一次的数字
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class OneNum {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
        for(int num : nums){
            for(int i = 0; i < 32; i++){
                arr[i] += num & 1;
                num >>>= 1;
            }
        }
        int result = 0, m = 3;
        for(int i = 0; i < 32; i++){
            result <<= 1;
            result |= arr[31 - i] % m;
        }
        return result;
    }
}
