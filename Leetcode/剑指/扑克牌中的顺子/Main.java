import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isStraight(new int[] {1,2,3,4,5}));
        System.out.println(new Solution().isStraight(new int[] {0,0,1,2,5}));
        System.out.println(new Solution().isStraight(new int[] {13,0,1,2,5}));
        System.out.println(new Solution().isStraight(new int[] {0,11,0,9,0}));
        System.out.println(new Solution().isStraight(new int[] {0,0,2,2,5}));
    }
}

class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }
        boolean re = true;
        for (int i = 4, j = count; i > j; i--) {
            count -= (nums[i] - nums[i-1] - 1);
            if (count < 0 || nums[i] == nums[i-1]) {
                re = false;
                break;
            }
        }
        return re;
    }
}