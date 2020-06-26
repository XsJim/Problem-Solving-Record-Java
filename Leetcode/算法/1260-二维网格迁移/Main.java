import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().shiftGrid(new int[][] {{1,2,3},{4,5,6},{7,8,9}}, 1));
        System.out.println(new Solution().shiftGrid(new int[][] {{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}}, 4));
        System.out.println(new Solution().shiftGrid(new int[][] {{1,2,3},{4,5,6},{7,8,9}}, 9));
    }
}

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int xBrake = grid.length, yBrake = grid[0].length;
        int i = k / yBrake, j = k % yBrake;
        i = (k % yBrake) != 0 ? i : (i - 1);
        i %= xBrake; i = xBrake - i - 1;
        j = j == 0 ? 0 : (yBrake - j);

        List<List<Integer>> lists = new ArrayList<>();
        for (int z = 0; z < xBrake; z++) {
            List<Integer> list = new ArrayList<>();
            for (int y = 0; y < yBrake; y++) {
                list.add(grid[i][j++]);
                if (j == yBrake) {
                    j = 0;
                    if (++i == xBrake) i = 0;
                }
            }
            lists.add(list);
        }

        return lists;
    }
}