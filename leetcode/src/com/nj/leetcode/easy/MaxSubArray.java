package com.nj.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 南江
 * @Description: 贪心算法和动态规划
 * @Date 2022/5/16 23:06
 */
public class MaxSubArray {
    /**
     *  贪心算法：若当前指针所指元素的和小于0，则丢弃当前元素的数列
     *  时间复杂度：O(N)  空间复杂度：O(1)
     */
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //当前值和最大值都取第一个元素
        int currMax = nums[0], subMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //num[i]和当前和于nums[i]，相加对比哪个最大取哪个
            currMax = Math.max(nums[i],currMax+nums[i]);
            //将当前和于最大和比较哪个最大取哪个
            subMax = Math.max(currMax,subMax);
        }
        System.out.println(subMax);
        System.out.println("-----------------------");
        int num = dynamicMethodArray(nums);
        System.out.println(num);
    }

    /**
     * 动态规划解决最大子序和：若前一个元素大于0，则将其加到当前元素上，
     *                    前一个元素小于0，保持当前元素不变
     * @param nums
     * @return
     */
    public static int dynamicMethodArray(int[] nums){
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(nums[0]);
        int number = 0;
        for (int i = 1; i < nums.length; i++) {
            if (arrayList.get(i-1) > 0){
                number = arrayList.get(i-1) + nums[i];
            }else {
                number = nums[i];
            }
            arrayList.add(number);
        }
        System.out.println(arrayList);
        Collections.sort(arrayList);
        arrayList =arrayList.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        return arrayList.get(arrayList.size()-1);
    }
}
