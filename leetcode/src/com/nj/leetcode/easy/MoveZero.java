package com.nj.leetcode.easy;

/**
 * @Author 南江
 * @Description: 移动零
 * @Date 2022/7/7 0:28
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
    }
    public static void moveZeroes(int[] nums) {
        //创建一个新数组长度根原数据保持一直
        int[] number = new int[nums.length];
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != 0){
                number[i-count] = nums[i];
            }else{
                count ++;
            }
        }
        for(int j = number.length - count; j< nums.length;j++){
            number[j] = 0;
        }
        nums = number;
    }

    public static void moveZero2(int[] nums){
        //创建一个新数组长度根原数据保持一直
        int index = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        for(int i = index; i< nums.length;i++){
            nums[i] = 0;
        }
    }
}
