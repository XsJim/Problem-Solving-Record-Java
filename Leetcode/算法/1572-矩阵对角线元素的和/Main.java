public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().diagonalSum(new int[][] {{1,2,3}, {4,5,6}, {7,8,9}}));
        System.out.println(new Solution().diagonalSum(new int[][] {{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}}));
        System.out.println(new Solution().diagonalSum(new int[][] {{5}}));
    }
}

class Solution {
    // 直接计算即可
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for (int i = 0, j = 0, z = n - 1; i < n; i++, j++, z--) {
            sum += mat[i][j];
            if (z != j) sum += mat[i][z];
        }

        return sum;
    }
}