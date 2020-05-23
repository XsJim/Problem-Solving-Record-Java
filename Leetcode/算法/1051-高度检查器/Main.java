import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().heightChecker(new int[] {1,1,4,2,1,3}));
        System.out.println(new Solution().heightChecker(new int[] {5,1,2,3,4}));
        System.out.println(new Solution().heightChecker(new int[] {1,2,3,4,5}));
    }
}

class Solution {
    public int heightChecker(int[] heights) {
        int[] cp = new int[heights.length];
        for (int i = 0; i < heights.length; i++) cp[i] = heights[i];
        Arrays.sort(cp);
        int sum = 0;
        for (int i = 0; i < heights.length; i++) if (cp[i] != heights[i]) sum++;
        return sum;
    }
}