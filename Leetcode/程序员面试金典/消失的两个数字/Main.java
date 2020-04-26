import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().missingTwo(new int[] {1})));
        System.out.println(Arrays.toString(new Solution().missingTwo(new int[] {2,3})));
    }
}

class Solution {
    public int[] missingTwo(int[] nums) {
        int[] check = new int[nums.length+2];
        for (int i = 0; i < nums.length; i++) {
            check[nums[i]-1] = -1;
        }
        int[] ans = new int[2];
        int j = 0;
        for (int i = 0; i < check.length; i++) {
            if (check[i] == 0) ans[j++] = i + 1;
        }
        return ans;
    }
}