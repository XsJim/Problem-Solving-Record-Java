public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().searchInsert(new int[] {1,3,5,6}, 5));
        System.out.println(new Solution().searchInsert(new int[] {1,3,5,6}, 2));
        System.out.println(new Solution().searchInsert(new int[] {1,3,5,6}, 7));
        System.out.println(new Solution().searchInsert(new int[] {1,3,5,6}, 0));
    }
}

class Solution {
    // 使用二分搜索查找
    // 当当前数字比查找数字大时，查找数字可能的插入位置为当前数字位置
    // 当当前数字比查找数字小时，查找数字可能的插入位置为当前数字位置的下一个
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
                ans = mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
                ans = left;
            }
            else return mid;
        }
        return ans;
    }
}