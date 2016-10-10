package net.helao.leetcode.lession7;

/**
 * 翻转integer，如 123 => 321
 * -123 => -321
 * <p>
 * 注意事项： 1. 翻转后有可能出现0在前面的情况
 * 2. 翻转后有可能导致integer溢出，溢出后需要返回0
 * Created by wangcheng<gates@mucang.cn> on 2016/10/10.
 */
public class Solution {

    public int reverse(int x) {
        boolean signbit = x > 0;
        int last = signbit ? x : -x;
        if (last <= 0) {
            return 0;
        }
        int result = 0;
        int prevResult = 0;
        do {
            prevResult = result;
            result = result * 10 + last % 10;
            last = last / 10;
        } while (last > 0);
        return (result > 0 && prevResult * 10 / 10 == prevResult) ? (signbit ? result : -result) : 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(321));
        System.out.println(s.reverse(-321));
        System.out.println(s.reverse(1000));
        System.out.println(s.reverse(-1000));
        System.out.println(s.reverse(0));
        System.out.println(s.reverse(2147483647));
        System.out.println(s.reverse(2147483641));
        System.out.println(s.reverse(-2147483648));
        System.out.println(s.reverse(-2147483641));
        System.out.println(s.reverse(1534236469));
    }
}
