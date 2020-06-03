public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[] {3,4,5,2}));
        System.out.println(new Solution().maxProduct(new int[] {1,5,4,5}));
        System.out.println(new Solution().maxProduct(new int[] {3,7}));
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        int max_1, max_2;
        if (nums[0] > nums[1]) {
            max_1 = nums[0];
            max_2 = nums[1];
        } else {
            max_1 = nums[1];
            max_2 = nums[0];
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max_1) {
                max_2 = max_1;
                max_1 = nums[i];
            }
            else if (nums[i] > max_2) {
                max_2 = nums[i];
            }
        }

        return (max_1 - 1) * (max_2 - 1);
    }
}