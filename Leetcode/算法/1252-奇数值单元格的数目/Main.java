public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().oddCells(2, 3, new int[][] {{0,1}, {1,1}}));
        System.out.println(new Solution().oddCells(2, 2, new int[][] {{1,1}, {0,0}}));
    }
}

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        boolean[] x = new boolean[n];
        boolean[] y = new boolean[m];
        for (int i = 0; i < indices.length; i++) {
            x[indices[i][0]] = !x[indices[i][0]];
            y[indices[i][1]] = !y[indices[i][1]];
        }
        int xx = 0, yy = 0;
        for (int i = 0; i < n; i++) {
            if (x[i]) xx++;
        }
        for (int i = 0; i < m; i++) {
            if (y[i]) yy++;
        }
        return xx*m + yy*n - 2*xx*yy;
    }
}