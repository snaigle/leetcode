package net.helao.leetcode.lession10;

/**
 * @author wangcheng<wangcheng@mucang.cn>
 * @date 2017/8/2.
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        if (s == null) {
            return p == null;
        }
        if (p == null) {
            return false;
        }
        if (s.equals(p)) {
            return true;
        }
        return doMatch(s, p);
    }

    public boolean doMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (p.length() == 0) {
            return false;
        }

        char p1 = p.charAt(0);
        String pLast = p.substring(1);
        boolean isStar = pLast.startsWith("*");
        if (isStar) {
            pLast = pLast.substring(1);
        }
        if (s.length() == 0) {
            if (isStar) {
                return doMatch(s, pLast);
            } else {
                return false;
            }
        }

        char s1 = s.charAt(0);
        String sLast = s.substring(1);

        if (p1 == '.') {
            if (isStar) {
                boolean match = false;
                for (int i = 0; i < s.length(); i++) {
                    match = doMatch(s.substring(i), pLast);
                    if (match) {
                        return true;
                    }
                }
                return doMatch("", pLast);
            } else {
                return doMatch(sLast, pLast);
            }
        } else {
            if (isStar) {
                boolean match = false;
                for (int i = 0; i < s.length(); i++) {
                    char ss = s.charAt(i);
                    if (ss == p1) {
                        match = doMatch(s.substring(i), pLast);
                        if (match) {
                            return true;
                        }
                    } else {
                        return doMatch(s.substring(i), pLast);
                    }
                }
                return doMatch("", pLast);
            } else {
                if (s1 == p1) {
                    return doMatch(sLast, pLast);
                } else {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("ab", ".*c"));
        System.out.println(s.isMatch("aa", "a"));
        System.out.println(s.isMatch("aa", "aa"));
        System.out.println(s.isMatch("aaa", "aa"));
        System.out.println(s.isMatch("aa", "a*"));
        System.out.println(s.isMatch("aa", ".*"));
        System.out.println(s.isMatch("ab", ".*"));
        System.out.println(s.isMatch("aab", "c*a*b"));
    }
}
