public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
        System.out.println(new Solution().longestPalindrome("cbbd"));
        System.out.println(new Solution().longestPalindrome("a"));
        System.out.println(new Solution().longestPalindrome("ac"));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        int max = 1;
        int max_begin_index = 0;
        int max_end = 1;
        for (int i = 0; i < s.length(); i++) {
            int cur_len = 1;
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                cur_len += 2;
                left--;
                right++;
            }
            if (cur_len > max) {
                max = cur_len;
                max_begin_index = left + 1;
                max_end = right;
            }

            left = i;
            right = i + 1;
            cur_len = 0;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                cur_len += 2;
                left--;
                right++;
            }
            if (cur_len > max) {
                max = cur_len;
                max_begin_index = left + 1;
                max_end = right;
            }
        }

        return new String(s.substring(max_begin_index, max_end));
    }
}