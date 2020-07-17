public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxPower("leetcode"));
        System.out.println(new Solution().maxPower("abbcccddddeeeeedcba"));
        System.out.println(new Solution().maxPower("triplepillooooow"));
        System.out.println(new Solution().maxPower("hooraaaaaaaaaaay"));
        System.out.println(new Solution().maxPower("tourist"));
    }
}

class Solution {
    public int maxPower(String s) {
        int max = 1, count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                count++;
            } else {
                if (count > max) max = count;
                if ((s.length() - i) <= max) break;
                count = 1;
            }
        }
        return Math.max(max, count);
    }
}