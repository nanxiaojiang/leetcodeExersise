package com.nj.leetcode.easy;

/**
 * @Author 南江
 * @Description: 买卖股票最佳时机
 * @Date 2022/7/1 1:16
 */
public class GuPiao {

    /**
     * 题目名称
     *
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     *
     */
    public static void main(String[] args) {
        int[] number = new int[]{7,1,5,3,6,4};
        int[] number2 = new int[]{7,6,4,3,1};

        int i = maxNumber(number);
        int i1 = maxNumber(number2);


        int dynamic = dynamic(number);
        int dynamic1 = dynamic(number2);

        System.out.println(111111);
    }

    /**
     *
     * 动态规划
     * @return
     */
    public static int dynamic(int[] prices){
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
            }else if (prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }

    /**
     * 双层for循环获取最大差值
     * @return
     */
    public static int maxNumber(int[] prices){
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int number = prices[j] - prices[i];
                if ( number > max){
                    max = number;
                }
            }
        }
        return max;
    }
}
