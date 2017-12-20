package net.helao.leetcode.lession5;

/**
 * 给定字符串，找出里面最长的那个回文串
 * 思路，按中心点将字符串循环一遍，判断最长的回文串
 * Created by snaigle on 16/9/9.
 */
public class Solution {

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            //要计算两种模式，
            // 偶数个
            String t1 = cal(s, i, false);
            if (t1.length() > result.length()) {
                result = t1;
            }
            // 奇数个
            String t2 = cal(s, i, true);
            if (t2.length() > result.length()) {
                result = t2;
            }
        }
        return result;
    }

    public String cal(String s, int i, boolean center) {
        //计算左右边界
        int left;
        int right;
        if (center) {
            left = i;
            right = i;
        } else {
            left = i - 1;
            if (left < 0) {
                return "";
            }
            right = i;
            if (s.charAt(left) != s.charAt(right)) {
                return "";
            }
        }
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("a"));
        System.out.println(new Solution().longestPalindrome("aa"));
        System.out.println(new Solution().longestPalindrome("ab"));
        System.out.println(new Solution().longestPalindrome("aba"));
        System.out.println(new Solution().longestPalindrome("aaa"));
        System.out.println(new Solution().longestPalindrome("aaaa"));
        System.out.println(new Solution().longestPalindrome("abba"));
        System.out.println(new Solution().longestPalindrome("abcba"));
        System.out.println(new Solution().longestPalindrome("abbaaaaa"));
    }
}
