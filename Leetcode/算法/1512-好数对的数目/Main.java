public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numIdenticalPairs(new int[] {1,2,3,1,1,3}));
        System.out.println(new Solution().numIdenticalPairs(new int[] {1,1,1,1}));
        System.out.println(new Solution().numIdenticalPairs(new int[] {1,2,3}));
    }
}

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) ans++;
            }
        }
        return ans;
    }
}