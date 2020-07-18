public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxForm(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(new Solution().findMaxForm(new String[] {"10", "0", "1"}, 1, 1));
        System.out.println(new Solution().findMaxForm(new String[] {"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"}, 90, 66));
    }
}

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            int[] count = new int[2];
            for (char x : strs[i].toCharArray()) {
                count[x-'0']++;
            }

            for (int j = m; j >= count[0]; j--) {
                for (int z = n; z >= count[1]; z--) {
                    dp[j][z] = Math.max(dp[j-count[0]][z-count[1]]+1, dp[j][z]);
                }
            }
        }

        return dp[m][n];
    }
}