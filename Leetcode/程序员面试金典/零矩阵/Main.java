import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,1,1}, {1,0,1}, {1,1,1}};
        new Solution().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        boolean[] x = new boolean[matrix.length];
        boolean[] y = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    x[i] = true;
                    y[j] = true;
                }
            }
        }

        for (int i = 0; i < x.length; i++) {
            if (x[i]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < y.length; i++) {
            if (y[i]) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}