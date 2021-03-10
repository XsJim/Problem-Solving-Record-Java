public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().sumOfUnique(new int[] {1,2,3,2}));
        System.out.println(new Solution().sumOfUnique(new int[] {1,1,1,1,1}));
        System.out.println(new Solution().sumOfUnique(new int[] {1,2,3,4,5}));
    }
}

class Solution {
    public int sumOfUnique(int[] nums) {
        int[] map = new int[101];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (++map[nums[i]] == 1) ans += nums[i];
            else if (map[nums[i]] == 2) ans -= nums[i];
        }

        return ans;
    }
}