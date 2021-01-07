public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().islandPerimeter(new int[][] {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}}));
        System.out.println(new Solution().islandPerimeter(new int[][] {{1}}));
        System.out.println(new Solution().islandPerimeter(new int[][] {{1,0}}));
    }
}

class Solution {
    public int islandPerimeter(int[][] grid) {
        int c = 0;
        int[] a = new int[] {1, -1, 0, 0}; 
        int[] b = new int[] {0, 0, -1, 1}; 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int x = i + a[d];
                        int y = j + b[d];
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[i].length) {
                            if (grid[x][y] == 0) c++;
                        } else {
                            c++;
                        }
                    }
                }
            }
        }

        return c;
    }
}