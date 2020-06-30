import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[] {3,0,1}));
        System.out.println(new Solution().missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != n && nums[i] != i) {
                swap(nums, i, nums[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != nums[i]) return i;
        }
        return n;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}