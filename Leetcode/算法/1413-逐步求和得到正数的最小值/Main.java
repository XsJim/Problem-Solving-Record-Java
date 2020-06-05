public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minStartValue(new int[] {-3,2,-3,4,2}));
        System.out.println(new Solution().minStartValue(new int[] {1,2}));
        System.out.println(new Solution().minStartValue(new int[] {1,-2,-3}));
    }
}

class Solution {
    public int minStartValue(int[] nums) {
        int min = 1000;
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < min) min = sum;
        }
        if (min >= 0) return 1;
        return 1 - min;
    }
}