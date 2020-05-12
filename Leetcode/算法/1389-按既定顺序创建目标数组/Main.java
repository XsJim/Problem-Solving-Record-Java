import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().createTargetArray(new int[] {0,1,2,3,4}, new int[] {0,1,2,2,1})));
        System.out.println(Arrays.toString(new Solution().createTargetArray(new int[] {1,2,3,4,0}, new int[] {0,1,2,3,0})));
        System.out.println(Arrays.toString(new Solution().createTargetArray(new int[] {1}, new int[] {0})));
    }
}

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] ans = new int[nums.length];
        for (int i = 0 ;i < nums.length; i++) {
            for (int j = i; j > index[i]; j--) {
                ans[j] = ans[j-1];
            }
            ans[index[i]] = nums[i];
        }
        return ans;
    }
}