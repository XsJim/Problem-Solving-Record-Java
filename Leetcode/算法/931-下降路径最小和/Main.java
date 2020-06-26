public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minFallingPathSum(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
    }
}

class Solution {
    public int minFallingPathSum(int[][] A) {
        int yBrake = A[0].length;
        for (int i = A.length - 2; i >= 0; i--) {
            int z = i + 1;
            A[i][0] += Math.min(A[z][0], A[z][1]);
            A[i][yBrake-1] += Math.min(A[z][yBrake-1], A[z][yBrake-2]);
            for (int j = 1; j < yBrake - 1; j++) {
                A[i][j] += Math.min(A[z][j], Math.min(A[z][j-1], A[z][j+1]));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < yBrake; i++) ans = Math.min(A[0][i], ans);
        return ans;
    }
}