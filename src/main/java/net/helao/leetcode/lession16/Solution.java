package net.helao.leetcode.lession16;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int result = 0;
        int gap = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int value = nums[i] + nums[j] + nums[k];
                int newGap = Math.abs(value - target);
                if (newGap < gap) {
                    result = value;
                    gap = newGap;
                }
                if (value < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}
