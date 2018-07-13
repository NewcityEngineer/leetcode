package com.newcitysoft.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 *  给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例:
 * <pre>
 *     给定 nums = [2, 7, 11, 15], target = 9
 *     因为 nums[0] + nums[1] = 2 + 7 = 9
 *     所以返回 [0, 1]
 * </pre>
 *
 * 官方解密：https://leetcode-cn.com/articles/two-sum/
 *
 * @author lixin.tian@renren-inc.com
 * @date 2018/7/13 10:43
 */
public class Code1 {

    /**
     * 时间复杂度：O(n^2)
     * 空间负责度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int firstIndex = -1;
        int secondIndex = -1;

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j <= nums.length - 1; j++) {
                if((nums[i] + nums[j]) == target) {
                    firstIndex = i;
                    secondIndex = j;
                }
            }
        }

        int[] result = {firstIndex, secondIndex};
        return result;
    }

    /**
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if(map.containsKey(result) && map.get(result) != i) {
                return new int[]{i, map.get(result)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * twoSum2 简化版
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2Up(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11, 15};
        int target = 26;

        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
        System.out.println("-----------------");
        int[] ints2 = twoSum2(nums, target);
        System.out.println(Arrays.toString(ints2));
        System.out.println("-----------------");
        int[] ints3 = twoSum2Up(nums, target);
        System.out.println(Arrays.toString(ints3));
    }
}
