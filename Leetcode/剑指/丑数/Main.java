public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
        System.out.println(new Solution().nthUglyNumber(1690));
    }
}

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int x = 0, y = 0, z = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[x]*2, Math.min(dp[y]*3, dp[z]*5));
            if (dp[i] == dp[x]*2) x++;
            if (dp[i] == dp[y]*3) y++;
            if (dp[i] == dp[z]*5) z++;
        }
        return dp[n-1];
    }
}