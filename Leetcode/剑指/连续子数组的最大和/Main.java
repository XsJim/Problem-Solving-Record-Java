public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int re = nums[0];
        int sum = 0;
        for (int i : nums) {
            sum += i;
            if (sum > re) re = sum;
            if (sum < 0) {
                sum = 0;
                continue;
            }
        }
        return re;
    }
}