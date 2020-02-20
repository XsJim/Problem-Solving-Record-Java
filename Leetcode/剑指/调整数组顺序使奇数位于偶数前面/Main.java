import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().exchange(new int[] {1,2})));
        System.out.println(Arrays.toString(new Solution().exchange(new int[] {2,1})));
        System.out.println(Arrays.toString(new Solution().exchange(new int[] {3,4,10,11})));
        System.out.println(Arrays.toString(new Solution().exchange(new int[] {2,4,1,3,5,9})));
    }
}

class Solution {
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) i++;
            while (i < j && (nums[j] & 1) == 0) j--;
            if (i < j) {
                nums[i] = nums[j] - nums[i];
                nums[j] -= nums[i];
                nums[i] += nums[j];
                i++;
                j--;
            }
        }
        return nums;
    }
}