import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        new Solution().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));

        matrix = new int[][] {{5, 1, 9,11}, {2, 4, 8,10}, {13, 3, 6, 7}, {15,14,12,16}};
        new Solution().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int m = n - i - 1;
            for (int j = i; j < m; j++) {
                int k = n - j - 1;
                int temp = matrix[j][m];
                matrix[j][m] = matrix[i][j];
                matrix[i][j] = matrix[k][i];
                matrix[k][i] = matrix[m][k];
                matrix[m][k] = temp;
            }
        }
    }
}