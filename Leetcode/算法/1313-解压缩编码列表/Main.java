import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().decompressRLElist(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(new Solution().decompressRLElist(new int[] {1,1,2,3})));
    }
}

class Solution {
    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i += 2) {
            len += nums[i];
        }
        int[] ans = new int[len];
        for (int i = 0, z = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                ans[z++] = nums[i+1];
            }
        }
        return ans;
    }
}