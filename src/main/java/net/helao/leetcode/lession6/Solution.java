package net.helao.leetcode.lession6;

/**
 * 给定字符串，并按zigzag模式重排后，读取
 * Created by snaigle on 16/9/10.
 */
public class Solution {
    public String convert(String s, int numRows) {
        assert numRows > 0;

        if (numRows == 1) {
            return s;
        }
        if (s == null || s.length() < 3) {
            return s;
        }
        StringBuilder[] tmp = new StringBuilder[numRows];
        int cycle = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            int y = i % cycle;
            if (y < numRows) {
                add(y, s.charAt(i), tmp);
            } else {
                add(2 * numRows - y - 2, s.charAt(i), tmp);
            }
        }
        StringBuilder result = new StringBuilder(s.length());
        for (int i = 0; i < tmp.length; i++) {
            result.append(tmp[i]== null?"":tmp[i]);
        }
        return result.toString();
    }

    private void add(int index, char c, StringBuilder[] tmp) {
        StringBuilder t = tmp[index];
        if (t == null) {
            t = new StringBuilder();
            tmp[index] = t;
        }
        t.append(c);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 3));
    }
}
