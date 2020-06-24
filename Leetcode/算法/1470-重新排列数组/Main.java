import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().shuffle(new int[] {2,5,1,3,4,7}, 3)));
        System.out.println(Arrays.toString(new Solution().shuffle(new int[] {1,2,3,4,4,3,2,1}, 4)));
        System.out.println(Arrays.toString(new Solution().shuffle(new int[] {1,1,2,2}, 2)));
    }
}

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        for (int i = 0, j = 0; i < nums.length; i += 2) ans[i] = nums[j++];
        for (int i = 1, j = n; i < nums.length; i += 2) ans[i] = nums[j++];
        return ans;
    }
}