public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[] {3,2,3}));
        System.out.println(new Solution().majorityElement(new int[] {2,2,1,1,1,2,2}));
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int val = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) val = nums[i];
            if (val == nums[i]) count++;
            else count--;
        }

        return val;
    }
}