import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isBoomerang(new int[][] {{1,1},{2,3},{3,2}}));
        System.out.println(new Solution().isBoomerang(new int[][] {{1,1},{2,2},{3,3}}));
    }
}

class Solution {
    // 两点相连为一直线，如果这三个点其中的两个都和另一个相连
    // 且形成的两条直线不在同一条直线上，那这三个点就可以组成一个三角形
    // 要确定具有公共点的两条直线是否在一条直线上，比较两线的斜率即可
    public boolean isBoomerang(int[][] points) {
        return (points[0][0]-points[1][0])*(points[1][1]-points[2][1])!=(points[0][1]-points[1][1])*(points[1][0]-points[2][0]);
    }

    // 如果三个点可以组成一个三角形，那么这三个点肯定不在一条直线上
    // 求三角形边时，需要开平方，得到的是浮点数，之后又进行了浮点数的比较，此算法不精确
    public boolean isBoomerang1(int[][] points) {
        double[] b = new double[3];
        b[0] = Math.sqrt(Math.pow(points[0][0]-points[1][0], 2) + Math.pow(points[0][1]-points[1][1], 2));
        b[1] = Math.sqrt(Math.pow(points[0][0]-points[2][0], 2) + Math.pow(points[0][1]-points[2][1], 2));
        b[2] = Math.sqrt(Math.pow(points[2][0]-points[1][0], 2) + Math.pow(points[2][1]-points[1][1], 2));
        Arrays.sort(b);
        if (b[0] + b[1] <= b[2]) return false;
        return true;
    }
}