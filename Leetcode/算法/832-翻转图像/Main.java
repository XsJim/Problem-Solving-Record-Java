import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().flipAndInvertImage(new int[][] {{1,1,0}, {1,0,1}, {0,0,0}})));
        System.out.println(Arrays.deepToString(new Solution().flipAndInvertImage(new int[][] {{1,1,0,0}, {1,0,0,1}, {0,1,1,1}, {1,0,1,0}})));
    }
}

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int j = 0, z = A[i].length - 1;
            while (j < z) {
                if (A[i][j] == 0 && A[i][z] == 0) {
                    A[i][j] = 1;
                    A[i][z] = 1;
                }
                else if (A[i][j] == 1 && A[i][z] == 1) {
                    A[i][j] = 0;
                    A[i][z] = 0;
                }
                j++; z--;
            }
        }

        if ((A[0].length & 1) == 1) {
            int mid = A[0].length / 2;
            for (int i = 0; i < A.length; i++) A[i][mid] ^= 1;
        }
        return A;
    }
}