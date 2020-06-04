public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[] {2,2,3,2}));
        System.out.println(new Solution().singleNumber(new int[] {0,1,0,1,0,1,99}));
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            a = (nums[i] ^ a) & ~b;
            b = (nums[i] ^ b) & ~a;
        }
        return a;
    }
}