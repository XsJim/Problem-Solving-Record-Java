import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    } 
}

// dfs
class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] xxb = new int[n*2];
        int[] yxb = new int[n*2];
        int[] yb = new int[n];
        int[][] map = new int[n][n];
        List<List<String>> lists = new ArrayList<>();
        dfs(map, xxb, yxb, yb, lists, 0, n);

        return lists;
    }

    private static void dfs(int[][] map, int[] xxb, int[] yxb, int[] yb, List<List<String>> lists, int x, int n) {
        if (x == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(map[i][j] == 0 ? '.' : 'Q');
                }
                list.add(sb.toString());
            }
            lists.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (yxb[x-i+n] == 0 && xxb[x+i] == 0 && yb[i] == 0) {
                xxb[x+i] = 1;
                yxb[x-i+n] = 1;
                yb[i] = 1;
                map[x][i] = 1;

                dfs(map, xxb, yxb, yb, lists, x+1, n);

                xxb[x+i] = 0;
                yxb[x-i+n] = 0;
                yb[i] = 0;
                map[x][i] = 0;
            }
        }
    }
}