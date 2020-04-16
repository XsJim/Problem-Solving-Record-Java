import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {5, 3, 1, 2, 3};
        new Solution().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution {
    public void wiggleSort(int[] nums) {
        int j = nums.length;
        int[] a = new int[j];
        for (int i = 0; i < j; i++) {
            a[i] = nums[i];
        }
        Arrays.sort(a);
        int z = nums.length - 1;
        for (int i = 0; i < j; i += 2) {
            nums[i] = a[z--];
        }
        for (int i = 1; i < j; i += 2) {
            nums[i] = a[z--];
        }
    }
}