package net.helao.leetcode.twosum;

import java.util.HashMap;

/**
 * 这个题有个简单算法,复杂度是log(n^2)
 * 下面这个算法是log(n)
 */
public class Answer1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>(nums.length);
        int[] result = null;
        for (int i = 0; i < nums.length; i++) {
            if (m.get(nums[i]) == null) {
                m.put(target - nums[i], i);
            } else {
                result = new int[]{m.get(nums[i]), i};
                break;
            }
        }
        return result;
    }
}
