import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().generateMatrix(3)));
        System.out.println(Arrays.deepToString(new Solution().generateMatrix(4)));
    }
}

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][];
        for (int i = 0; i < n; i++) {
            ans[i] = new int[n];
        }
        int l = -1, r = n, u = -1, d = n;
        int x = 0, y = 0;
        int z = 1;
        int m = n * n;

        while (true) {
            while (y < r) ans[x][y++] = z++;
            if (z > m) break;
            x++; y--; u++;
            while (x < d) ans[x++][y] = z++;
            if (z > m) break;
            x--; y--; r--;
            while (y > l) ans[x][y--] = z++;
            if (z > m) break;
            x--; y++; d--;
            while (x > u) ans[x--][y] = z++;
            if (z > m) break;
            x++; y++; l++;
        }

        return ans;
    }
}