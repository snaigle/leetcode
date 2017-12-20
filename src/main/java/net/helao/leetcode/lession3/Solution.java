package net.helao.leetcode.lession3;

/**
 * given a string, find the length of the longest substring without repeating characters
 * <p>
 * Examples:
 * Given 'pwwkew', the answer is 'wke'
 * <p>
 * Created by snaigle on 16/8/24.
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            if (temp.indexOf(c) == -1) {
                temp.append(c);
            } else {
                if (temp.length() > max) {
                    max = temp.length();
                }
                int index = temp.lastIndexOf(c);
                temp.delete(0, index + 1);
                temp.append(c);
            }
        }
        if (temp.length() > max) {
            max = temp.length();
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("aab"));
    }
}
