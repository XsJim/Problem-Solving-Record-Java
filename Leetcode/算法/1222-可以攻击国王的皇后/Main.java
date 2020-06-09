import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().queensAttacktheKing(new int[][] {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}}, new int[] {0,0}));
    }
}

class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> lists = new LinkedList<>();
        boolean[][] x = new boolean[8][];
        for (int i = 0; i < 8; i++) x[i] = new boolean[8];
        for (int i = 0; i < queens.length; i++) {
            x[queens[i][0]][queens[i][1]] = true;
        }
        int[] a = new int[] {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] b = new int[] {0, 0, -1, 1, -1, 1, -1, 1};
        for (int i = 0; i < 8; i++) {
            int aa = king[0], bb = king[1];
            while (aa >= 0 && aa < 8 && bb >= 0 && bb < 8) {
                if (x[aa][bb]) {
                    List<Integer> list = new LinkedList<>();
                    list.add(aa); list.add(bb);
                    lists.add(list);
                    break;
                }
                aa += a[i]; bb += b[i];
            }
        }
        return lists;
    }
}