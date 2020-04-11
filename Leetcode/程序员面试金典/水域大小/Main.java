import java.util.LinkedList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().pondSizes(new int[][] {{0,2,1,0}, {0,1,0,1}, {1,1,0,1}, {0,1,0,1}})));
    }
}

class Solution {
    private static int len = 8;
    private static int[] a = new int[] {1, -1, 0, 0, -1, -1, 1, 1};
    private static int[] b = new int[] {0, 0, -1, 1, -1, 1, -1, 1};

    public int[] pondSizes(int[][] land) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0) {
                    int[] sum = new int[] {0};
                    dfs(land, i, j, list, sum);
                    list.add(sum[0]);
                }
            }
        }

        int[] ans = new int[list.size()];
        int i = 0;
        for (int x : list) {
            ans[i++] = x;
        }
        Arrays.sort(ans);
        return ans;
    }

    private static void dfs(int[][] land, int i, int j, LinkedList<Integer> list, int[] sum) {
        land[i][j] = 1;
        sum[0]++;
        for (int z = 0; z < len; z++) {
            int ii = i + a[z];
            int jj = j + b[z];
            if (ii >= 0 && ii < land.length && jj >= 0 && jj < land[ii].length && land[ii][jj] == 0) {
                    dfs(land, ii, jj, list, sum);
            }
        }
    }
}