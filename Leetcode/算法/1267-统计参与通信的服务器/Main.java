public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countServers(new int[][] {{1,0},{0,1}}));
        System.out.println(new Solution().countServers(new int[][] {{1,0},{1,1}}));
        System.out.println(new Solution().countServers(new int[][] {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}}));
    }
}

class Solution {
    public int countServers(int[][] grid) {
        int[] xCount = new int[grid.length];
        int[] yCount = new int[grid[0].length];

        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    xCount[i]++; yCount[j]++;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && (xCount[i] > 1 || yCount[j] > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}