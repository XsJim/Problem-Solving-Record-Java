public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring(""));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        final int R = 256;
        int[] index = new int[R];
        for (int i = 0; i < R; i++) index[i] = -1;
        int max_len = 0;
        int cur_len = 0;
        int min_index = -1;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i);
            if (index[x] < min_index) index[x] = -1;
            if (index[x] == -1) {
                index[x] = i;
                cur_len++;
                if (cur_len > max_len) max_len = cur_len;
            } else {
                cur_len = i - index[x];
                min_index = index[x];
                index[x] = i;
            }
        }

        return max_len;
    }
}