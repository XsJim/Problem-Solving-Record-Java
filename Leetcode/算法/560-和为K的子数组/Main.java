public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[] {1,1,1}, 2));
    }
}

class Solution {
    // 前缀和
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (sum[j] - sum[i] + nums[j] == k) ans++;
            }
        }

        return ans;
    }
}