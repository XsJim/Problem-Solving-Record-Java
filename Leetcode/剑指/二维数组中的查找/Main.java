public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        System.out.println(solution.findNumberIn2DArray(matrix , 5));
        System.out.println(solution.findNumberIn2DArray(matrix , 20));
    }
}

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean re = false;
        talgo:
        for (int[] i : matrix) {
            for (int j : i) {
                if (j == target) {
                    re = true;
                    break talgo;
                }
                else if (j > target) break;
            }
        }

        return re;
    }
}