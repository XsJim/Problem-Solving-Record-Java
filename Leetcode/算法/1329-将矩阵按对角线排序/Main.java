import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().diagonalSort(new int[][] {{3,3,1,1}, {2,2,1,2}, {1,1,1,2}})));
    }
}

// 遍历每一条斜线，同时使用桶来记录每个数字出现次数
// 再次遍历斜线，将桶数不为 0 的桶对应的数填入矩阵
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int c = mat.length + mat[0].length - 1;
        int x = mat.length - 1, y = 0;
        while (c-- > 0) {
            if (x == 0) {
                y++;
            } else {
                x--;
            }
            int[] t = new int[101];
            for (int i = x, j = y; i < mat.length && j < mat[i].length; i++, j++) {
                t[mat[i][j]]++;
            }
            int ind = 1;
            for (int i = x, j = y; i < mat.length && j < mat[i].length; i++, j++) {
                while (t[ind] == 0) ind++;
                t[ind]--;
                mat[i][j] = ind;
            }
        }
        return mat;
    }
}