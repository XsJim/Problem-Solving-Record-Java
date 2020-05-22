import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().matrixBlockSum(new int[][] {{1,2,3}, {4,5,6}, {7,8,9}}, 1)));
        System.out.println(Arrays.deepToString(new Solution().matrixBlockSum(new int[][] {{1,2,3}, {4,5,6}, {7,8,9}}, 2)));
    }
}


class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int x = mat.length;
        int y = mat[0].length;
        int[][] p = new int[x+1][y+1];
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                p[i][j] = mat[i-1][j-1] + p[i][j-1] + p[i-1][j] - p[i-1][j-1];
            }
        }
        int[][] ans = new int[x][y];
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                int i1, i2, j1, j2;
                i1 = Math.max(i - K, 1);
                i2 = Math.min(i + K, x);
                j1 = Math.max(j - K, 1);
                j2 = Math.min(j + K, y);
                ans[i-1][j-1] = p[i2][j2] - p[i2][j1-1] - p[i1-1][j2] + p[i1-1][j1-1];
            }
        }
        return ans;
    }
}