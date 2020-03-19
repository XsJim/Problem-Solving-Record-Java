public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().canPermutePalindrome("tactcoa"));
        System.out.println(new Solution().canPermutePalindrome(""));
        System.out.println(new Solution().canPermutePalindrome("aa"));
        System.out.println(new Solution().canPermutePalindrome("aaa"));
        System.out.println(new Solution().canPermutePalindrome("abab"));
        System.out.println(new Solution().canPermutePalindrome("abcd"));
    }
}

class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null) return false;
        if (s.length() <= 1 ) return true;
        int R = 256;
        int[] count = new int[R];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count[chars[i]]++;
        }
        int flag = 0;
        for (int i = 0; i < R ; i++) {
            if (count[i] % 2 != 0) flag++;
        }
        if (flag > 1) return false;
        if ((s.length() % 2) == flag) return true;
        return false;
    }
}