public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().strToInt("42"));
        System.out.println(new Solution().strToInt("   -42"));
        System.out.println(new Solution().strToInt("4193 with words"));
        System.out.println(new Solution().strToInt("words and 987"));
        System.out.println(new Solution().strToInt("-91283472332"));
        System.out.println(new Solution().strToInt("91283472332 asdas"));
        System.out.println(new Solution().strToInt(" +111"));
    }
}


class Solution {
    public int strToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;
        
        if (str.charAt(0) != '+' && str.charAt(0) != '-' && (str.charAt(0) > '9' || str.charAt(0) < '0')) {
            return 0;
        } else {
            char[] chars = str.toCharArray();
            boolean flag = false;
            int i = 0;
            if (chars[i] == '-') {
                flag = true;
                i++;
                if (i >= chars.length || chars[i] > '9' || chars[i] < '0') return 0;
            }
            if (chars[i] == '+') i++;
            double number = 0;
            while (i < chars.length && chars[i] <= '9' && chars[i] >= '0') {
                number *= 10;
                number += (chars[i++] - '0');
                if (flag) {
                    if (number > -1.0*Integer.MIN_VALUE) return Integer.MIN_VALUE;
                } else {
                    if (number > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                }
            }
            if (flag) number *= -1;
            return (int)number;
        }
    }
}