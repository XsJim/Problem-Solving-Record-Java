public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minTimeToVisitAllPoints(new int[][] {{1,1},{3,4},{-1,0}}));
        System.out.println(new Solution().minTimeToVisitAllPoints(new int[][] {{3,2},{-2,2}}));
    }
}

// 题目给定，必须按照数组给定的点的顺序访问点
// 所以，每次参与运算的只有两个点
// 首先，判断两点是否在一个正方形的两个对角上，如果是，则直接加上走过斜对角线需要的时间
// 否则，先按照最大正方形走斜边，再走直线到达目标点
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        for (int i = 1; i < points.length; i++) {
            int x = Math.abs(points[i][0]-points[i-1][0]);
            int y = Math.abs(points[i][1]-points[i-1][1]);

            if (x == y) sum += x;
            else {
                sum += (Math.min(x, y) + Math.abs(x-y));
            }
        }

        return sum;
    }
}