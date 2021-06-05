package com.sipeiouyang.zcy.other;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 跳跃游戏
 *
 * 给定数组 arr，arr[i]==k 代表可以从位置 i 向右跳 1~k 个距离。比如，arr[2]==3，
 * 代表可以 从位置 2 跳到位置 3、位置 4 或位置 5。如果从位置 0 出发，
 * 返回最少跳几次能跳到 arr 最后的 位置上。
 */
public class MinStep {

    public static int getMinStep(int[] arr){
        if (arr == null || arr.length < 1){
            return 0;
        }
        /**
         * 当前跳了多少次
         **/
        int jump = 0;
        /**
         * 当前走到哪一步了
         **/
        int cur = 0;
        /**
         * 再跳一步最远能到到位置
         **/
        int next = 0;
        for(int i = 0; i < arr.length; i++){
            if (cur < i){
                jump++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return jump;
    }
}
