import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[] {1,1}));
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int[] nums_copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) nums_copy[i] = nums[i];
        Arrays.sort(nums_copy);
        int re = 0;
        int re_n = 0;
        int z = nums_copy[0], j = 0;
        for (int i : nums_copy) {
            if (i == z) {
                j++;
            } else {
                if (j > re_n) {
                    re = z;
                    re_n = j;
                }
                z = i;
                j = 1;
            }
        }
        if (j > re_n) re = z;
        return re;
    }
}