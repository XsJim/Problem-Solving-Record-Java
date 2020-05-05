public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().waysToChange(5));
        System.out.println(new Solution().waysToChange(10));
        System.out.println(new Solution().waysToChange(1000000));
    }
}

class Solution {
    public int waysToChange(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        int[] money = new int[] {1, 5, 10, 25};
        for (int i = 0; i < 4; i++) {
            for (int j = money[i]; j <= n; j++) {
                dp[j] += dp[j-money[i]];
                dp[j] %= 1000000007;
            }
        }
        return dp[n];
    }
}