package com.nj.leetcode.easy;

/**
 * @Author 南江
 * @Description:    爬楼梯
 * @Date 2022/7/1 0:37
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Stairs {

    public static void main(String[] args) {
        int climbStairs = climbStairs(5);

        int i = climbStairs2(2);
        System.out.println("");
    }

    /**
     * 动态规划处理
     * @param n
     * @return
     */
    public static int climbStairs2(int n){
        if (n == 1){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 递归处理
     * @param n N阶
     * @return  思路：f1 = 1   f2 = 2      (n必须大于3)fn = fn-1 + fn-2
     */
    public static int climbStairs(int n){
        if (n == 1 || n == 2){
            return n;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
