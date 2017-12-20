package net.helao.leetcode.lession99;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定 一组数字如"123455653",算出可能的ip地址
 * Created by snaigle on 16/8/23.
 */
public class Solution {
    public static void main(String[] args) {
        List<String> a = new Solution().restoreIpAddresses("25525511135");
        for (String b : a) {
            System.out.println(b);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null) {
            return result;
        }
        int length = s.length();
        if (length < 4 || length > 12) {
            return result;
        }
        for (int i0 = 1; i0 < 4; i0++) {
            for (int i1 = 1; i1 < 4; i1++) {
                for (int i2 = 1; i2 < 4; i2++) {
                    int i3 = length - i0 - i1 - i2;
                    if (i3 > 0 && i3 < 4) {
                        String p0 = s.substring(0, i0);
                        if (isValid(p0)) {
                            String p1 = s.substring(i0, i0 + i1);
                            if (isValid(p1)) {
                                String p2 = s.substring(i0 + i1, i0 + i1 + i2);
                                if (isValid(p2)) {
                                    String p3 = s.substring(i0 + i1 + i2);
                                    if (isValid(p3)) {
                                        result.add(new StringBuilder(p0)
                                                .append(".")
                                                .append(p1)
                                                .append(".")
                                                .append(p2)
                                                .append(".")
                                                .append(p3)
                                                .toString()
                                        );
                                    }
                                }
                            }
                        }

                    }
                }
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
