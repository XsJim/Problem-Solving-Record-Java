public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpaces("Mr John Smith    ", 13));
        System.out.println(new Solution().replaceSpaces("               ", 5));
        System.out.println(new Solution().replaceSpaces("", 0));
    }
}

class Solution {
    public String replaceSpaces(String S, int length) {
        S = S.substring(0, length);
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                sb.append("%20");
            } else sb.append(chars[i]);
        }
        return sb.toString();
    }
}