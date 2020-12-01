import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxWidthOfVerticalArea(new int[][] {{8,7}, {9,9}, {7,4}, {9,7}}));
    }
}

// 求连续相邻两点之间的最大横向距离
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b)->{
            return Integer.compare(a[0], b[0]);
        });

        int max = -1;
        for (int i = 1; i < points.length; i++) max = Math.max(points[i][0]-points[i-1][0], max);
        return max;
    }
}