import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().pathWithObstacles(new int[][] {{0,0,0}, {0,1,0}, {0,0,0}});
        for (List<Integer> list : lists) {
            for (int x : list) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}

class Solution {
    private static int[] a = new int[] {0, 1};
    private static int[] b = new int[] {1, 0};

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> lists = new LinkedList<>();
        if (obstacleGrid.length > 0 && obstacleGrid[0].length > 0 &&  obstacleGrid[0][0] != 1) {
            boolean[][] map = new boolean[obstacleGrid.length][obstacleGrid[0].length];
            boolean[] flag = new boolean[1];
            map[0][0] = true;
            dfs(0, 0, obstacleGrid, flag, lists, map);
            if (!flag[0]) lists.remove(0);
        }
        return lists;
    }

    private static void dfs(int i, int j, int[][] obstacleGrid, boolean[] flag, List<List<Integer>> lists, boolean[][] map) {
        List<Integer> list = new LinkedList<>();
        list.add(i); list.add(j);
        lists.add(list);
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[i].length - 1) {
            flag[0] = true;
            return;
        }
        for (int z = 0; z < 2; z++) {
            int ii = i + a[z], jj = j + b[z];
            if (ii < obstacleGrid.length && jj < obstacleGrid[ii].length && obstacleGrid[ii][jj] != 1 && !map[ii][jj]) {
                map[ii][jj] = true;
                dfs(ii, jj, obstacleGrid, flag, lists, map);
                if (flag[0]) return;
                lists.remove(lists.size()-1);
            }
        }
    }
}