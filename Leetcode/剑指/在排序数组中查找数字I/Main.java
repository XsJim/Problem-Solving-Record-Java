public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[] {5,7,7,8,8,10}, 8));
        System.out.println(new Solution().search(new int[] {5,7,7,8,8,10}, 6));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int re = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) break;
            if (nums[i] == target) {
                while (i < nums.length && nums[i] == target) {
                    re++;
                    i++;
                }
                break;
            }
        }
        return re;
    }
}