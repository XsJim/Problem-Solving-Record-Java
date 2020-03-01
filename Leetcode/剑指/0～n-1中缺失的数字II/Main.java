public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[] {0,1,3}));
        System.out.println(new Solution().missingNumber(new int[] {0,1,2,3,4,5,6,7,9}));
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int re = 0;
        for (int i = 0; i < nums.length; i++, re++) {
            if (re != nums[i]) break;
        }
        return re;
    }
}