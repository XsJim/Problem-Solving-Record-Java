public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().massage(new int[] {1,2,3,1}));
        System.out.println(new Solution().massage(new int[] {2,7,9,3,1}));
        System.out.println(new Solution().massage(new int[] {2,1,4,5,3,1,1,3}));

    }
}

class Solution {
    public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        int dp1 = nums[0], dp2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int tdp1 = dp2 + nums[i];
            int tdp2 = Math.max(dp1, dp2);

            dp1 = tdp1;
            dp2 = tdp2;
        }
        return Math.max(dp1, dp2);
    }
}