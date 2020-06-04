public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[] {3}));
        System.out.println(new Solution().singleNumber(new int[] {1, 3, 1}));
        System.out.println(new Solution().singleNumber(new int[] {0, 0, 2, 7, 1, 2, 1}));
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int re = 0;
        for (int i = nums.length - 1; i >= 0; i--) re ^= nums[i];
        return re;
    }
}