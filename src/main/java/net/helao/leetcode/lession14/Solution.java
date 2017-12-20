package net.helao.leetcode.lession14;

/**
 * @author snaigle
 * @date 2017/8/3.
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String prefix = strs[0];
        String s;
        for (int i = 1; i < strs.length; i++) {
            s = strs[i];
            prefix = findCommonPrefix(prefix, s);
            if (prefix.equals("")) {
                return "";
            }
        }
        return prefix;
    }

    public String findCommonPrefix(String a, String b) {
        if (a.equals("") || b.equals("")) {
            return "";
        }
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return a.substring(0, i);
            }
        }
        return len == a.length() ? a : b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"a", "bsd", "as"}));

    }
}
