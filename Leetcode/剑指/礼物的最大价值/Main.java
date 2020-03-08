public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(new int[][] {{1,3,1,6},{1,5,1,8},{4,2,1,9}}));
    }
}

class Solution {
    public int maxValue(int[][] grid) {
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[i] = dp[i-1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < grid[i].length; j++) {
                dp[j] = Math.max(grid[i][j]+dp[j-1], grid[i][j]+dp[j]);
            }
        }
        return dp[grid[0].length-1];
    }
}