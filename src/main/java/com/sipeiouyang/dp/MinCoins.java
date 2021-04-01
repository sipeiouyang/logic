package com.sipeiouyang.dp;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 给定数组 arr，arr 中所有的值都为正数且不重复。每个值代表一种面值的货币，
 * 每种面值 的货币可以使用任意张，再给定一个整数 aim，代表要找的钱数，求组成 aim 的最少货币数。
 *
 * 举例:
 * arr=[5,2,3]，aim=20。
 * 4 张 5 元可以组成 20 元，其他的找钱方案都要使用更多张的货币，所以返回 4。 arr=[5,2,3]，aim=0。
 * 不用任何货币就可以组成 0 元，返回 0。
 * arr=[3,5]，aim=2。
 * 根本无法组成 2 元，钱不能找开的情况下默认返回-1。
 *
 * 求最值
 */
public class MinCoins {

    /**
     * 先写出暴力解法
     **/
    public static int minCoins(int[] arr, int aim){
        if (arr == null || arr.length < 1 || aim < 0){
            return -1;
        }
        return minCoins(arr, 0, aim);
    }

    /**
     * 这个递归函数的作用：
     * 得到以面值arr[index]时，还剩aim需要找零的组合最少货币数
     * 如果返回-1，表示找不开
     * 暴力解法，需要试arr[index]不同数量时的货币数
     **/
    private static int minCoins(int[] arr, int index, int aim){
        if (index == arr.length){
            if (aim == 0){
                return 0;
            }
            return -1;
        }
        int result = -1;
        for (int num = 0; num * arr[index] <= aim; num++){
            int next = minCoins(arr, index + 1, aim - num * arr[index]);
            if (next != -1){
                result = result == -1 ? next + num : Math.min(next + num, result);
            }
        }
        return result;
    }

}
