import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().kClosest(new int[][] {{1,3}, {-2,2}}, 1)));
        System.out.println(Arrays.deepToString(new Solution().kClosest(new int[][] {{3,3}, {5,-1}, {-2,4}}, 2)));
        System.out.println(Arrays.deepToString(new Solution().kClosest(new int[][] {{0,1}, {1,0}}, 2)));
        System.out.println(Arrays.deepToString(new Solution().kClosest(new int[][] {{2,2}, {2,2}, {2,2}, {2,2}, {2,2}, {2,2}, {1,1}}, 1)));
        System.out.println(Arrays.deepToString(new Solution().kClosest(new int[][] {{1,3}, {-2,2}, {2,-2}}, 2)));
    }
}

class Solution {
    class Node {
        int x;
        int[] p;
        Node(int x, int[] p) {
            this.x = x;
            this.p = p;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        Node[] p = new Node[points.length];
        for (int i = 0; i < points.length; i++) {
            p[i] = new Node(em(points[i][0], points[i][1]), points[i]);
        }
        Arrays.sort(p, (a, b) -> {
            return Integer.compare(a.x, b.x);
        });
        int[][] ans = new int[K][];
        for (int i = 0; i < K; i++) ans[i] = p[i].p;
        return ans;
    }

    private static int em(int x, int y) {
        return (int)(Math.pow(x, 2) + Math.pow(y, 2));
    }
}