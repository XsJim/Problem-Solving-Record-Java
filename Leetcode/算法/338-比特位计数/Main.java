import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countBits(2)));
        System.out.println(Arrays.toString(new Solution().countBits(5)));
    }
}

class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i>>1] + (i & 1);
        }
        return dp;
    }
}