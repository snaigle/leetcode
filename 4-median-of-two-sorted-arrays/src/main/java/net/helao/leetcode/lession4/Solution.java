package net.helao.leetcode.lession4;

/**
 * 求两个已排序数组的共同中位数
 * 刚开始看到题，第一印象就是用归并排序，处理到中位数时，直接返回值即可，tc为 log((n+m)/2)。
 * 可看题给出tc为 log(n+m)，让我很困惑，没想到方案，只能按归并来处理，提交后就被接受了，测试运行时间5ms，看了时间分布图，5ms比c和c++还要快了
 * 很疑惑别人是怎么做的，为什么这么慢
 * Created by wangcheng<gates@mucang.cn> on 16/9/6.
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLen = len1 + len2;

        boolean isOdd = totalLen % 2 == 0;
        int medianIndex = totalLen / 2;

        int i1 = 0;
        int i2 = 0;
        int last = 0;
        for (int i = 0; i < len1 + len2; i++) {

            int result;
            boolean add1;
            if (i1 >= nums1.length) {
                add1 = false;
            } else if (i2 >= nums2.length) {
                add1 = true;
            } else {
                add1 = nums1[i1] <= nums2[i2];
            }
            result = add1 ? nums1[i1] : nums2[i2];
            if (add1) {
                i1++;
            } else {
                i2++;
            }
            if (i == medianIndex) {
                if (isOdd) {
                    return (result + last) / 2.0D;
                } else {
                    return result;
                }
            } else {
                last = result;
            }
        }
        return 0d;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2};
        int[] b = {2, 4};
        System.out.println(new Solution().findMedianSortedArrays(a, b));
    }
}
