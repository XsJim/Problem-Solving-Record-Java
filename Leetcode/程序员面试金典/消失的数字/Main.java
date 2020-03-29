public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[] {3,0,1}));
        System.out.println(new Solution().missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
        System.out.println(new Solution().missingNumber(new int[] {9,6,4,2,3,5,7,8,1}));
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x ^= nums[i];
            x ^= (i + 1);
        }
        return x;
    }
}