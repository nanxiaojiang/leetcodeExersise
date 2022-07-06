package com.nj.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author 南江
 * @Description: 多数元素
 * @Date 2022/7/1 21:29
 * <p>
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class ManyNumbers {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3, 4, 5, 6, 1,1,1,1};
        int numbers = getNumbers(nums);
        int next = getNext(nums);
        int i = get(nums);
        System.out.println();
    }

    private static int get(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }

    /**
     * 由于众数出现的频率大于n/2,所以在排序之后众数必存在于下标[n/2]处(本题默认数组中是一定存在众数的，所以返回下标[n/2]可行)
     *
     * @return
     */
    public static int getNext(int[] nums) {
        //我们先将 nums 数组排序，然后返回上文所说的下标对应的元素
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * map 解决多数元素问题
     *
     * @param nums map的key 存储元素，value 存储元素出现的个数
     * @return
     */
    public static int getNumbers(int[] nums) {
        int num = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue() > num) {
                return next.getKey();
            }
        }

        return -1;
    }
}
