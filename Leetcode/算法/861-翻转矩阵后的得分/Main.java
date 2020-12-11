public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().matrixScore(new int[][] {{0,0,1,1},{1,0,1,0},{1,1,0,0}}));
    }
}

// 首先使第一列全变为1
// 然后遍历之后的列，如果某列1的个数少于0的个数，则将该列反转
// 最后求和即可

class Solution {
    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] != 1) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] ^= 1;
                }
            }
        }

        for (int i = 1; i < A[0].length; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                count += A[j][i];
            }
            if (count < (A.length + 1) / 2) {
                for (int j = 0; j < A.length; j++) {
                    A[j][i] ^= 1;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int xsum = 0;
            for (int j = 0; j < A[i].length; j++) {
                xsum <<= 1;
                xsum |= A[i][j];
            }
            sum += xsum;
        }

        return sum;
    }
}