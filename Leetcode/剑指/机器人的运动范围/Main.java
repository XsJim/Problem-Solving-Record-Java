public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(2, 3, 1));
        System.out.println(new Solution().movingCount(3, 1, 0));
    }
}

class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] flag = new boolean[m][n];
        flag[0][0] = true;
        return 1 + dfs(0, 0, flag, k, new int[] {-1, 1, 0, 0}, new int[] {0, 0, -1, 1});
    }

    private static int dfs(int i, int j, boolean[][] flag, int k, int[] a, int[] b) {
        int re = 0;
        for (int z = 0; z < 4; z++) {
            int ii = i + a[z];
            int jj = j + b[z];
            if (ii >= 0 && ii < flag.length && jj >= 0 && jj < flag[ii].length && !flag[ii][jj] && talgo(ii, jj, k)) {
                flag[ii][jj] = true;
                re++;
                re += dfs(ii, jj, flag, k, a, b);
            }
        }
        return re;
    }

    private static boolean talgo(int i, int j, int k) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        if (sum > k) return false;
        return true;
    }
}