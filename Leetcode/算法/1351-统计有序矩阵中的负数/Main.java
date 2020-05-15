public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countNegatives(new int[][] {{4,3,2,-1}, {3,2,1,-1}, {1,1,-1,-2}, {-1,-1,-2,-3}}));
        System.out.println(new Solution().countNegatives(new int[][] {{3,2}, {1,0}}));
        System.out.println(new Solution().countNegatives(new int[][] {{1,-1}, {-1,-1}}));
        System.out.println(new Solution().countNegatives(new int[][] {{-1}}));
    }
}

class Solution {
    public int countNegatives(int[][] grid) {
        int sum = 0;
        int xMax = grid.length;
        int yMax = grid[0].length;
        for (int i = 0; i < xMax; i++) {
            for (int j = 0; j < yMax; j++) {
                if (grid[i][j] >= 0) sum++;
                else {
                    if (j == 0) xMax = i;
                    yMax = j;
                    break;
                }
            }
        }
        return grid.length * grid[0].length - sum;
    }
}