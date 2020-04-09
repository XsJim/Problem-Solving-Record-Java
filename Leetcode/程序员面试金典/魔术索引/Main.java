public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findMagicIndex(new int[] {0, 2, 3, 4, 5}));
        System.out.println(new Solution().findMagicIndex(new int[] {1, 1, 1}));
    }
}

class Solution {
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) return i;
        }
        return -1;
    }
}