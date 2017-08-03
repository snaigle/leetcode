package net.helao.leetcode.lession11;

import java.time.Clock;

/**
 * @author wangcheng<wangcheng@mucang.cn>
 * @date 2017/8/2.
 */
public class Solution {

    public int maxArea(int[] height) {
        int maxArea = 0, i = 0, j = height.length - 1;
        int min = 0;
        while (i < j) {
            min = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, min * (j - i));
            while (i < j && height[i] <= min) {
                ++i;
            }
            while (i < j && height[j] <= min) {
                --j;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[15000];
        for (int i = 0; i < 15000; i++) {
            height[i] = 15000 - i;
        }
        long s = Clock.systemUTC().millis();
        int a = new Solution().maxArea(height);
        System.out.println(a);
        System.out.println(Clock.systemUTC().millis() - s);
    }
}
