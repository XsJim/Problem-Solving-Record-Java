public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[] {3,2,1,5,6,4}, 2));
        System.out.println(new Solution().findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0, right = nums.length-1;
        while (left != right) {
            int mid = hoare(nums, left, right);
            if (mid > k) {
                right = mid - 1;
            }
            else if (mid < k) {
                left = mid + 1;
            } else break;
        }
        return nums[k];
    }

    private static int hoare(int[] nums, int left, int right) {
        int temp = nums[left];
        int i = left, j = right + 1;
        while (true) {
            while (nums[++i] <= temp) if (i == right) break;
            while (nums[--j] > temp) if (j == left) break;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}