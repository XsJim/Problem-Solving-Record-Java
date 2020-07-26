public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePathsIII(new int[][] {{1,0,0,0}, {0,0,0,0}, {0,0,2,-1}}));
        System.out.println(new Solution().uniquePathsIII(new int[][] {{1,0,0,0}, {0,0,0,0}, {0,0,0,2}}));
        System.out.println(new Solution().uniquePathsIII(new int[][] {{0,1}, {2,0}}));
    }
}

class Solution {
    public int uniquePathsIII(int[][] grid) {
        int sum_0 = 0;
        int sx = -1, sy = -1;
        int bx = -1, by = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    sx = i; sy = j;
                }
                else if (grid[i][j] == 2) {
                    bx = i; by = j;
                }
                else if (grid[i][j] == 0) sum_0++;
            }
        }

        int[] ans = new int[1];
        int[] ax = new int[] {0, 0, -1, 1};
        int[] ay = new int[] {-1, 1, 0, 0};
        grid[sx][sy] = -1;
        talgo(grid, sx, sy, bx, by, -1, sum_0, ans, ax, ay);
        grid[sx][sy] = 1;

        return ans[0];
    }

    private static void talgo(int[][] grid, int nx, int ny, int bx, int by, int current_0, int sum_0, int[] ans, int[] ax, int[] ay) {
        if (nx == bx && ny == by) {
            if (current_0 == sum_0) {
                ans[0]++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nnx = nx + ax[i];
            int nny = ny + ay[i];
            if (nnx >= 0 && nnx < grid.length && nny >= 0 && nny < grid[nnx].length && grid[nnx][nny] != -1) {
                int temp = grid[nnx][nny];
                grid[nnx][nny] = -1;
                talgo(grid, nnx, nny, bx, by, current_0+1, sum_0, ans, ax, ay);
                grid[nnx][nny] = temp;
            }
        }
    }
}