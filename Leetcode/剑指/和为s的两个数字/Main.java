import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {2,7,11,15}, 9)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {10,26,30,31,47,60}, 400)));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            }
            else if (sum < target) {
                i++;
            } else {
                break;
            }
        }
        if (i < j) {
            return new int[] {nums[i], nums[j]};
        } else {
            return new int[0];
        }
    }
}