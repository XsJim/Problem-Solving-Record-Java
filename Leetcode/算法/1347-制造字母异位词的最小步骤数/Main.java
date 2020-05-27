public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minSteps("bab", "aba"));
        System.out.println(new Solution().minSteps("leetcode", "practice"));
        System.out.println(new Solution().minSteps("anagram", "mangaar"));
        System.out.println(new Solution().minSteps("xxyyzz", "xxyyzz"));
        System.out.println(new Solution().minSteps("friend", "family"));
    }
}

class Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        for (char x : s.toCharArray()) count[x-'a']++;
        for (char x : t.toCharArray()) count[x-'a']--;
        int sum = 0;
        for (int x : count) if (x > 0) sum += x;
        return sum;
    }
}