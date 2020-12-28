public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumWealth(new int[][] {{1,2,3}, {3,2,1}}));
        System.out.println(new Solution().maximumWealth(new int[][] {{1,5}, {7,3}, {3,5}}));
    }
}

// 求最大值
class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = -1;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) sum += accounts[i][j];
            if (sum > max) max = sum;
        }
        return max;
    }
}