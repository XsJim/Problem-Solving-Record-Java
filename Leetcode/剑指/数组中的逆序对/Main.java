public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reversePairs(new int[] {7,5,6,4}));
        System.out.println(new Solution().reversePairs(new int[] {1}));
        System.out.println(new Solution().reversePairs(new int[] {7,5,6,4,9,9}));
        System.out.println(new Solution().reversePairs(new int[] {1,1,1,1,1}));
    }
}

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, new int[nums.length], 0, nums.length-1);
    }

    private static int mergeSort(int[] nums, int[] numsux, int left, int right) {
        if (left >= right) return 0;
        int mid = (right + left) / 2;
        int leftSum = mergeSort(nums, numsux, left, mid);
        int rightSum = mergeSort(nums, numsux, mid+1, right);
        return leftSum + rightSum + merge(nums, numsux, left, mid, right);
    }

    private static int merge(int[] nums, int[] numsux, int left, int mid, int right) {
        for (int k = left; k <= right; k++) numsux[k] = nums[k];
        int i = left, j = mid + 1;
        int sum = 0;
        for (int k = left; k <= right; k++) {
            if (i > mid) nums[k] = numsux[j++];
            else if (j > right) nums[k] = numsux[i++];
            else if (numsux[i] > numsux[j]) {
                sum += (mid - i + 1);
                nums[k] = numsux[j++];
            } else nums[k] = numsux[i++];
        }
        return sum;
    }
}