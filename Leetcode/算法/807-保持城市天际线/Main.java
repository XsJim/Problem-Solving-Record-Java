public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxIncreaseKeepingSkyline(new int[][] {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
    }
}

// 首先遍历二维数组，找到每行每列对应的最大值
// 再次遍历数组，每个元素应该变为当前元素对应行列最大值中的较小值与其本身相比的最大值
// 根据题意，应该将这个改变后的值与原来值的差加入结果中
// 第二次遍历之后，就得到了这个值
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] txmax = new int[grid.length];
        int[] tymax = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > txmax[i]) {
                    txmax[i] = grid[i][j];
                }
                if (grid[i][j] > tymax[j]) {
                    tymax[j] = grid[i][j];
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int x = Math.max(grid[i][j], Math.min(tymax[j], txmax[i]));
                sum += (x-grid[i][j]);
            }
        }

        return sum;
    }
}