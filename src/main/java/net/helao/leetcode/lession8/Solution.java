package net.helao.leetcode.lession8;

/**
 * string to int
 * for example:
 * <ul>
 * <li> '123' => 123 </li>
 * <li> ' 123 ' => 123 </li>
 * <li> ' 123a' => 123 </li>
 * <li> ' +123' => 123 </li>
 * <li> ' -123' => -123 </li>
 * <li> ' abd ' => 0 </li>
 * <li> ' 21474836472' => 2147483647 </li>
 * <li> ' -21474836472' => -2147483648 </li>
 * </ul>
 * Created by snaigle on 2016/10/13.
 */
public class Solution {
    public int myAtoi(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        int result = 0;
        int length = 0;
        boolean sign = true;// 符号
        boolean whitespaceBit = true;
        boolean signBit = true;
        for (int i = 0; i < str.length(); i++) {
            // 这里排除掉字符串前面的空白
            char c = str.charAt(i);
            if (whitespaceBit) {
                whitespaceBit = ' ' == c || '\t' == c;
            }
            if (!whitespaceBit) {
                if (signBit) {
                    signBit = false;
                    if (c == '-') {
                        sign = false;
                        continue;
                    } else if (c == '+') {
                        sign = true;
                        continue;
                    } else if (c <= '9' && c >= '0') {
                        // 直接以数据开始为正数
                        sign = true;
                    } else {// 不合法串
                        return 0;
                    }
                }
                if (c <= '9' && c >= '0') {
                    int addon = (sign ? 1 : -1) * (c - 48);
                    if (length == 9) {
                        // 在这里判断是不是溢出了
                        int r2 = result * 10;

                        if (r2 / 10 != result || (sign && r2 + addon < 0) || (!sign && r2 + addon > 0)) {
                            // 溢出
                            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                        }
                    } else if (length > 9) {
                        // 溢出
                        return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                    result = result * 10 + addon;
                    length++;
                } else {// 可以结束了
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("123"));
        System.out.println(s.myAtoi("+123"));
        System.out.println(s.myAtoi("-123"));
        System.out.println(s.myAtoi("   123"));
        System.out.println(s.myAtoi("   -123"));
        System.out.println(s.myAtoi("   a123"));
        System.out.println(s.myAtoi("   123a"));
        System.out.println(s.myAtoi("   21474836472"));
        System.out.println(s.myAtoi("   -21474836472"));
        System.out.println(s.myAtoi("-2147483647"));
    }
}
