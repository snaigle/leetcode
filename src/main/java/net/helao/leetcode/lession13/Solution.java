package net.helao.leetcode.lession13;

import java.util.HashMap;
import java.util.Map;

/**
 * @author snaigle
 * @date 2017/8/3.
 */
public class Solution {

    public int romanToInt(String s) {
        int n = 0;
        Map<String, Integer> map = new HashMap<>(7);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        String prev = null;
        int prevValue = 0;
        String c;
        int value;
        for (int i = 0; i < s.length(); i++) {
            c = s.substring(i, i + 1);
            value = map.get(c);
            n += value;
            if (prev != null && prevValue < value) {
                n -= prevValue * 2;
            }
            prev = c;
            prevValue = value;

        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("MMMDCCCLXXXVIII"));
    }
}
