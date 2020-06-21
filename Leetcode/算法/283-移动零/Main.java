import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,12};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int i = -1, j = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                if (i == -1) i = j;
            } else {
                if (i != -1) nums[i++] = nums[j];
            }
            j++;
        }
        if (i != -1) while (i < nums.length) nums[i++] = 0;
    }
}