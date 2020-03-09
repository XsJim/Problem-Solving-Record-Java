public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[] {3,4,3,3}));
        System.out.println(new Solution().singleNumber(new int[] {9,1,7,9,7,9,7}));
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int[] array = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            for (int j = 0; j < 32; j++) {
                array[j] += (x & 1);
                x >>>= 1;
            }
        }
        int re = 0;
        for (int i = 31; i >= 0; i--) {
            re <<= 1;
            if (array[i] % 3 != 0) {
                re += 1;
            }
        }
        return re;
    }
}