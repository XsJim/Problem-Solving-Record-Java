public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[] {-1,0,3,5,9,12}, 9));
        System.out.println(new Solution().search(new int[] {-1,0,3,5,9,12}, 2));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            }
            else if (nums[mid] < target) {
                l = mid + 1;
            } else return mid;
        }
        return -1;
    }
}