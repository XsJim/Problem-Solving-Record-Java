public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isToeplitzMatrix(new int[][] {{1,2,3,4}, {5,1,2,3}, {9,5,1,2}}));
        System.out.println(new Solution().isToeplitzMatrix(new int[][] {{1,2}, {2,2}}));
    }
}

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            int ii = i + 1, j = 1;
            while (ii < matrix[0].length && j < matrix.length) {
                if (matrix[j-1][ii-1] != matrix[j][ii]) return false;
                ii++; j++;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            int ii = i + 1, j = 1;
            while (ii < matrix.length && j < matrix[0].length) {
                if (matrix[ii-1][j-1] != matrix[ii][j]) return false;
                ii++; j++;
            }
        }

        return true;
    }
}