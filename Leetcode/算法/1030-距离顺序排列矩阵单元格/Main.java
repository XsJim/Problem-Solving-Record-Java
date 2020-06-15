import java.util.Arrays;
import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().allCellsDistOrder(1, 2, 0, 0)));
        System.out.println(Arrays.deepToString(new Solution().allCellsDistOrder(2, 2, 0, 1)));
        System.out.println(Arrays.deepToString(new Solution().allCellsDistOrder(2, 3, 1, 2)));
    }
}

class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ans = new int[R*C][];
        ans[0] = new int[] {r0, c0};
        int[] l = new int[] {r0, c0-1};
        int[] r = new int[] {r0, c0+1};
        int[] u = new int[] {r0-1, c0};
        int[] d = new int[] {r0+1, c0};
        int x = 1;
        int tmax = max(max(abs(0-r0) + abs(0-c0), abs(0-r0) + abs(C-1-c0)), max(abs(R-1-r0) + abs(0-c0), abs(R-1-r0) + abs(C-1-c0)));
        for (int z = 0; z < tmax; z++) {
            for (int i = d[0], j = d[1]; i != l[0] && j != l[1]; i--, j--) {
                if (check(i, j, R, C)) ans[x++] = new int[] {i, j};
            }
            for (int i = l[0], j = l[1]; i != u[0] && j != u[1]; i--, j++) {
                if (check(i, j, R, C)) ans[x++] = new int[] {i, j};
            }
            for (int i = u[0], j = u[1]; i != r[0] && j != r[1]; i++, j++) {
                if (check(i, j, R, C)) ans[x++] = new int[] {i, j};
            }
            for (int i = r[0], j = r[1]; i != d[0] && j != d[1]; i++, j--) {
                if (check(i, j, R, C)) ans[x++] = new int[] {i, j};
            }
            l[1]--; r[1]++; u[0]--; d[0]++;
        }
        return ans;
    }

    private static boolean check(int i, int j, int R, int C) {
        if (i >= 0 && i < R && j >= 0 && j < C) return true;
        return false;
    }
}