import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[] {1,2,3,4})));
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0, x = 1; i < nums.length; i++) {
            ans[i] = x;
            x *= nums[i];
        }
        for (int i = nums.length - 1, x = 1; i >= 0; i--) {
            ans[i] *= x;
            x *= nums[i];
        }
        return ans;
    }
}