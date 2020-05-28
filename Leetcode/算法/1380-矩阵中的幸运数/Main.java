import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().luckyNumbers(new int[][] {{3,7,8}, {9,11,13}, {15,16,17}}));
        System.out.println(new Solution().luckyNumbers(new int[][] {{1,10,4,2}, {9,3,8,7}, {15,16,17,12}}));
        System.out.println(new Solution().luckyNumbers(new int[][] {{7,8}, {1,2}}));
    }
}

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] min = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) min[i] = 1000000;
        int[] max = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min[i]) min[i] = matrix[i][j];
                if (matrix[i][j] > max[j]) max[j] = matrix[i][j];
            }
        }
        List<Integer> ans = new LinkedList<>();
        for (int x : min) {
            for (int y : max) {
                if (x == y) ans.add(x);
            }
        }
        return ans;
    }
}