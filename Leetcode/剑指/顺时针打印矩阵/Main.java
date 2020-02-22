import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().spiralOrder(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}})));
    }
}

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int reLength = matrix[0].length * matrix.length;
        int[] re = new int[reLength];
        int l = 0, r = matrix[0].length - 1, u = 0, d = matrix.length - 1;
        int i = 0, j = 0, x = 0;
        while (x < reLength) {
            while (j <= r && x < reLength) re[x++] = matrix[i][j++];
            u++; j--; i++;
            while (i <= d && x < reLength) re[x++] = matrix[i++][j];
            r--; i--; j--;
            while (j >= l && x < reLength) re[x++] = matrix[i][j--];
            d--; j++; i--;
            while (i >= u && x < reLength) re[x++] = matrix[i--][j];
            l++; i++; j++;
        }
        return re;
    }
}