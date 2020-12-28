import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().transpose(new int[][] {{1,2,3},{4,5,6},{7,8,9}})));
        System.out.println(Arrays.deepToString(new Solution().transpose(new int[][] {{1,2,3},{4,5,6}})));
    }
}

class Solution {
    public int[][] transpose(int[][] A) {
        int[][] ans = new int[A[0].length][A.length];
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                ans[i][j] = A[j][i];
            }
        }
        return ans;
    }
}