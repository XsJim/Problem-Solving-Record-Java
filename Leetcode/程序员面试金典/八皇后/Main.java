import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(4);
        for (List<String> list : lists) {
            for (String str : list) {
                System.out.println(str);
            }
            System.out.println("----------------");
        }
    }
}

class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[] a = new boolean[2*n-1];
        boolean[] b = new boolean[2*n-1];
        boolean[] c = new boolean[n];
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = '.';
            }
        }
        List<List<String>> lists = new LinkedList<>();
        dfs(map, a, b, c, 0, lists);
        return lists;
    }

    private static void dfs(char[][] map, boolean[] a, boolean[] b, boolean[] c, int j, List<List<String>> lists) {
        int n = map.length;
        if (j == n) {
            List<String> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                String row = "";
                for (int z = 0; z < n; z++) {
                    row += map[i][z];
                }
                list.add(row);
            }
            lists.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            int aa = j-i+n-1, bb = j+i;
            if (!c[i] && !a[aa] && !b[bb]) {
                map[j][i] = 'Q';
                c[i] = true; a[aa] = true; b[bb] = true;
                dfs(map, a, b, c, j+1, lists);
                map[j][i] = '.';
                c[i] = false; a[aa] = false; b[bb] = false;
            }
        }
    }
}