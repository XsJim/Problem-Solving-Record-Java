public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int len = 0;
        for (int x : nums) {
            if (x == 1) len++;
            else {
                if (len > max) max = len;
                len = 0;
            }
        }
        return Math.max(len, max);
    }
}