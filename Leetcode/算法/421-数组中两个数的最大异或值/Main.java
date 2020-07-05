public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findMaximumXOR(new int[] {3, 10, 5, 25, 2, 8}));
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] ^ nums[j]) > ans) ans = nums[i] ^ nums[j];
            }
        }
        return ans;
    }
}