import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().imageSmoother(new int[][] {{1,1,1},{1,0,1},{1,1,1}})));
    }
}

class Solution {
    // 保存原图，新建副本，依次遍历元素填答案便可
    public int[][] imageSmoother(int[][] M) {
        int[][] ans = new int[M.length][];
        int[] a = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] b = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < ans.length; i++) {
            ans[i] = new int[M[i].length];
            for (int j = 0; j < ans[i].length; j++) {
                int sum = M[i][j];
                int n = 1;
                for (int z = 0; z < 8; z++) {
                    int ii = i + a[z];
                    int jj = j + b[z];
                    if (ii >= 0 && ii < M.length && jj >= 0 && jj < M[ii].length) {
                        sum += M[ii][jj];
                        n++;
                    }
                }
                ans[i][j] = sum / n;
            }
        }

        return ans;
    }
}