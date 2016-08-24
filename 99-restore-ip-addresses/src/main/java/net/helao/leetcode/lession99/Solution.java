package net.helao.leetcode.lession99;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定 一组数字如"123455653",算出可能的ip地址
 * Created by wangcheng<gates@mucang.cn> on 16/8/23.
 */
public class Solution {
    public static void main(String[] args) {
        List<String> a = new Solution().restoreIpAddresses("1125511");
        for (String b : a) {
            System.out.println(b);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        // 为空 或 长度小4时,无法构成一个ip串，直接返回
        // ([0-9]|[1-9][0-9]|[1][0-9]{2}|[2][0-4][0-9]|[2][5][0-5])\.
        if (s == null || s.length() < 4 || s.length() > 12) {
            return new ArrayList<String>();
        }
        return internalMatch(0, "", s);
    }

    public List<String> internalMatch(int index, String preffix, String after) {
        List<String> result = new ArrayList<String>();
        int length = after.length();
        if (length > 0) {
            if (index == 3) {
                if (length <= 3 && isValid(after)) {
                    result.add(preffix + "." + after);
                }
            } else {
                char c = after.charAt(0);
                if (c == '0') {
                    // 只有一位
                    result.addAll(internalSubstring(index, 1, preffix, after));
                } else if (c == '1' || c == '2') {
                    // 有1,2,3位三种情况
                    result.addAll(internalSubstring(index, 1, preffix, after));
                    result.addAll(internalSubstring(index, 2, preffix, after));
                    result.addAll(internalSubstring(index, 3, preffix, after));
                } else {
                    // 只有1,2位两种情况
                    result.addAll(internalSubstring(index, 1, preffix, after));
                    result.addAll(internalSubstring(index, 2, preffix, after));
                }

            }
        }
        return result;
    }

    public List<String> internalSubstring(int index, int subCount, String preffix, String after) {
        List<String> result = new ArrayList<String>();
        if (subCount <= after.length()) {
            String param = after.substring(0, subCount);
            if (isValid(param)) {
                if (index != 0) {
                    preffix += '.';
                }
                preffix += param;
                result.addAll(internalMatch(index + 1, preffix, after.substring(subCount)));
            }
        }
        return result;
    }

    public boolean isValid(String content) {
        char c = content.charAt(0);
        if (c == '0') {
            return content.length() == 1;
        } else {
            return Integer.parseInt(content) <= 255;
        }
    }
}
