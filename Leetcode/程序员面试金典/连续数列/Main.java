public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) sum = 0;
        }
        return max;
    }
}