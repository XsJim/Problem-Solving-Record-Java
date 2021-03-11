public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().check(new int[] {3,4,5,1,2}));
        System.out.println(new Solution().check(new int[] {2,1,3,4}));
        System.out.println(new Solution().check(new int[] {1,2,3}));
        System.out.println(new Solution().check(new int[] {1,1,1}));
        System.out.println(new Solution().check(new int[] {2,1}));
    }
}

class Solution {
    public boolean check(int[] nums) {
        int flag = 0;
        if (nums[0] < nums[nums.length-1]) flag = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                if (flag == 1) return false;
                flag = 1;
            }
        }
        return true;
    }
}