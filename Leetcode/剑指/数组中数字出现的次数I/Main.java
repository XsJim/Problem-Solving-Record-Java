import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().singleNumbers(new int[] {4,1,4,6})));
        System.out.println(Arrays.toString(new Solution().singleNumbers(new int[] {1,2,10,4,1,4,3,3})));
        System.out.println(Arrays.toString(new Solution().singleNumbers(new int[] {3,9})));
    }
}

class Solution {
    public int[] singleNumbers(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x ^= nums[i];
        }
        int y = 1;
        while ((y & x) != y) {
            y <<= 1;
        }
        int[] re = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & y) == y) re[0] ^= nums[i];
            else re[1] ^= nums[i];
        }
        return re;
    }
}