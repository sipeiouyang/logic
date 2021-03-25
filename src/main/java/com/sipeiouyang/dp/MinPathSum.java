package com.sipeiouyang.dp;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 给定一个矩阵 m，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径 上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 *
 * 如果给定的 m 如下:
 * 1    3   5   9
 * 8    1   3   4
 * 5    0   6   1
 * 8    8   4   0
 *
 * 路径 1，3，1，0，6，1，0 是所有路径中路径和最小的，所以返回 12。
 */
public class MinPathSum {

    /**
     * 此方法时间、空间复杂度均为O(M*N)
     **/
    public static Integer fun1(int[][] arr){
        if (arr == null || arr.length < 1 || arr[0] == null || arr[0].length < 1){
            return 0;
        }
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = arr[0][0];
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for(int i = 1; i < n; i++){
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        for(int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

}
