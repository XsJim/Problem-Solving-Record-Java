public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8}));
        System.out.println(new Solution().singleNonDuplicate(new int[] {3,3,7,7,10,11,11}));
    }
}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if ((mid & 1) == 1) mid--;
            if (nums[mid] == nums[mid+1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}