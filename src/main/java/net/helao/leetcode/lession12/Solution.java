package net.helao.leetcode.lession12;

/**
 * @author wangcheng<wangcheng@mucang.cn>
 * @date 2017/8/3.
 */
public class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder(12);
        int i = 0, a, rest = num;
        char[] cc = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int start;

        do {
            a = rest % 10;
            rest = rest / 10;
            start = 2 * i;
            i++;
            switch (a) {
                case 3:
                    sb.append(cc[start]);
                case 2:
                    sb.append(cc[start]);
                case 1:
                    sb.append(cc[start]);
                case 0:
                    break;
                case 4:
                    sb.append(cc[start + 1]);
                    sb.append(cc[start]);
                    break;
                case 8:
                    sb.append(cc[start]);
                case 7:
                    sb.append(cc[start]);
                case 6:
                    sb.append(cc[start]);
                case 5:
                    sb.append(cc[start + 1]);
                    break;
                case 9:
                    sb.append(cc[start + 2]);
                    sb.append(cc[start]);
            }
        } while (rest > 0);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3999));
        System.out.println(new Solution().intToRoman(9));
        System.out.println(new Solution().intToRoman(900));
        System.out.println(new Solution().intToRoman(789));
        System.out.println(new Solution().intToRoman(678));
        System.out.println(new Solution().intToRoman(1234));
        System.out.println(new Solution().intToRoman(3456));
        System.out.println(new Solution().intToRoman(3341));
        System.out.println(new Solution().intToRoman(3333));
    }
}
