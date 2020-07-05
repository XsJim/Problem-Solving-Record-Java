import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArray(new int[] {5,2,3,1})));
        System.out.println(Arrays.toString(new Solution().sortArray(new int[] {5,1,1,2,0,0})));
    }
}

class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length, new int[nums.length]);
        return nums;
    }

    private static void sort(int[] nums, int b, int e, int[] temp) {
        if (b + 1 == e) return;
        int mid = (b + e) / 2;
        sort(nums, b, mid, temp);
        sort(nums, mid, e, temp);
        merge(nums, temp, b, mid, e);
    }

    private static void merge(int[] nums, int[] temp, int l, int x, int r) {
        int left = l, i = l, mid = x;
        while (i < r) {
            while (left < mid && nums[left] <= nums[x]) temp[i++] = nums[left++];
            if (left == mid) break;
            while (x < r && nums[x] <= nums[left]) temp[i++] = nums[x++];
            if (x == r) break;
        }
        while (left < mid) temp[i++] = nums[left++];
        while (x < r) temp[i++] = nums[x++];
        while (l < r) nums[l] = temp[l++];
    }
}