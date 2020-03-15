public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("ab"));
        System.out.println(new Solution().lengthOfLongestSubstring("bacabcabb"));
        System.out.println(new Solution().lengthOfLongestSubstring("   "));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() == 1) return 1;
        int R = 256;
        int[] count = new int[R];
        for (int i = 0; i < R; i++) {
            count[i] = -1;
        }
        char[] chars = s.toCharArray();
        int max = 0;
        int tlength = 0;
        int tbegin = 0;
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i]] < 0) {
                count[chars[i]] = i;
                tlength++;
                if (tlength > max) max = tlength;
            } else {
                tlength -= (count[chars[i]] - tbegin);
                tbegin = count[chars[i]] + 1;
                for (int j = 0; j < R; j++) {
                    if (count[j] < count[chars[i]]) {
                        count[j] = -1;
                    }
                }
                count[chars[i]] = i;
            }
        }
        return max;
    }
}