public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new int[] {1,3,4,2,2}));
        System.out.println(new Solution().findDuplicate(new int[] {3,1,3,4,2}));
        System.out.println(new Solution().findDuplicate(new int[] {1,1}));
        System.out.println(new Solution().findDuplicate(new int[] {1,1,2}));
    }
}

//计数
class Solution {
    public int findDuplicate(int[] nums) {
        int[] count = new int[30001];
        for (int i = 0; i < nums.length; i++) {
            if (++count[nums[i]] == 2) return nums[i];
        }

        return 0;
    }
}