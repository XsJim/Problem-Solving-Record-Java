public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minPathSum(new int[][] {{1,3,1}, {1,5,1}, {4,2,1}}));
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        // if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int i = 1;
        while (i < n) {grid[0][i] += grid[0][i-1]; i++;}
        i = 1;
        while (i < m) {grid[i][0] += grid[i-1][0]; i++;}
        i = 1;
        while (i < m) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
            i++;
        }
        return grid[m-1][n-1];
    }
}