public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countGoodRectangles(new int[][] {{5,8},{3,9},{5,12},{16,5}}));
        System.out.println(new Solution().countGoodRectangles(new int[][] {{2,3},{3,7},{4,3},{3,7}}));
    }
}

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int max_l = 0;
        int ans = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int min_l = Math.min(rectangles[i][0], rectangles[i][1]);
            if (min_l == max_l) ans++;
            else if (min_l > max_l) {
                max_l = min_l;
                ans = 1;
            }
        }

        return ans;
    }
}