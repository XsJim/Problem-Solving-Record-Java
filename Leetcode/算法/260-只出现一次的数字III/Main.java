import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().singleNumber(new int[] {1,2,1,3,2,5})));
    }
}

class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;

        int diff = bitmask & (-bitmask);

        int x = 0;
        for (int num : nums) if ((num & diff) != 0) x ^= num;

        return new int[] {x, bitmask^x};
    }
}