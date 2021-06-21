package com.jiwei.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 */
public class Solution0001 {

    public static void main(String[] args) {
        int[] arr = {3, 3};
        int target = 6;
        int[] solution = solution(arr, target);
        System.out.println(Arrays.toString(solution));
    }

    /**
     * 暴力算法
     *
     * @param arr
     * @param target
     * @return
     */
    public static int[] solution(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target && i != j) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 哈希表求解，时间复杂度O(n)
     *
     * @param arr
     * @param target
     * @return
     */
    public static int[] solution2(int[] arr, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int x = target - arr[i];
            if (hashMap.containsKey(x)) {
                return new int[]{hashMap.get(x), i};
            }
            hashMap.put(arr[i], i);
        }
        return new int[0];
    }

}
