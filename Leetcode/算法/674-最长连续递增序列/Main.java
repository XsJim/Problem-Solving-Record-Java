public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findLengthOfLCIS(new int[] {1,3,5,4,7}));
        System.out.println(new Solution().findLengthOfLCIS(new int[] {2,2,2,2,2}));
    }
}

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int ans = 1;
        int n = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) n++;
            else {
                if (n > ans) ans = n;
                n = 1;
                if (ans > (nums.length - i)) break;
            }
        }
        if (n > ans) ans = n;

        return ans;
    }
}