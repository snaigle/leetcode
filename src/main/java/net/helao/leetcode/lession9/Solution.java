package net.helao.leetcode.lession9;

/**
 * 判断一个整数是否回文的，例如
 * <pre>
 *    * 1 --> true
 *    * 11 --> true
 *    * 121 --> true
 *    * 12 --> false
 *    * -1 --> false
 *
 * </pre>
 * Created by snaigle on 2016/10/14.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int[] bits = new int[10];
        byte index = 0;
        int last = x;
        do {
            bits[index++] = last % 10;
            last = last / 10;
        } while (last > 0);
        for (int i = 0; i < index / 2; i++) {
            if (bits[i] != bits[index - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(1));
        System.out.println(s.isPalindrome(11));
        System.out.println(s.isPalindrome(121));
        System.out.println(s.isPalindrome(123));
        System.out.println(s.isPalindrome(-11));
    }
}
