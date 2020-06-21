public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().kLengthApart(new int[] {1,0,0,0,1,0,0,1}, 2));
        System.out.println(new Solution().kLengthApart(new int[] {1,0,0,1,0,1}, 2));
        System.out.println(new Solution().kLengthApart(new int[] {1,1,1,1,1}, 0));
        System.out.println(new Solution().kLengthApart(new int[] {0,1,0,1}, 1));
    }
}

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i = 0, j;
        while (i < nums.length && nums[i] == 0) i++;
        while (i < nums.length) {
            j = i + 1;
            while (j < nums.length && nums[j] == 0) j++;
            if (j < nums.length && j - i - 1 < k) return false;
            i = j;
        }
        return true;
    }
}