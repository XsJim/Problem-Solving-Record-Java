public class Main {
    public static void main(String[] args) {
        int[][] matrix =
           new int[][] {{1,   4,  7, 11, 15}, {2,   5,  8, 12, 19}, {3,   6,  9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(new Solution().searchMatrix(matrix, 5));
        System.out.println(new Solution().searchMatrix(matrix, 20));
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        return talgo(matrix, target, 0, 0, flag);
    }

    private static boolean talgo(int[][] matrix, int target, int i, int j, boolean[][] flag) {
        if (i >= matrix.length || j >= matrix[i].length || flag[i][j]) return false;
        flag[i][j] = true;
        if (matrix[i][j] > target) return false;
        if (matrix[i][j] < target) {
            return talgo(matrix, target, i+1, j, flag)
               || talgo(matrix, target, i, j+1, flag)
               || talgo(matrix, target, i+1, j+1, flag);
        }
        return true;
    }
}