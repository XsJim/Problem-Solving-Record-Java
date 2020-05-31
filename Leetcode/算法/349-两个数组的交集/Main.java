import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersection(new int[] {1,2,2,1}, new int[] {2,2})));
        System.out.println(Arrays.toString(new Solution().intersection(new int[] {4,9,5}, new int[] {9,4,9,8,4})));
    }
}

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] min;
        int[] max;
        if (nums1.length > nums2.length) {
            max = nums1; min = nums2;
        } else {
            max = nums2; min = nums1;
        }
        Arrays.sort(min);
        boolean[] flag = new boolean[min.length];
        int[] a = new int[min.length];
        int sum = 0;
        for (int i = 0; i < max.length; i++) {
            if (b_s(flag, min, max[i])) {
                a[sum++] = max[i];
            }
        }
        int[] ans = new int[sum];
        for (int i = 0; i < sum; i++) ans[i] = a[i];
        return ans;
    }

    private static boolean b_s(boolean[] flag, int[] find, int key) {
        int left = 0, right = find.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (find[mid] < key) left = mid + 1;
            else if (find[mid] > key) right = mid - 1;
            else {
                if (flag[mid]) return false;
                for (int i = mid; i >= 0 && find[i] == find[mid]; i--) flag[i] = true;
                for (int i = mid; i < find.length && find[i] == find[mid]; i++) flag[i] = true;
                return true;
            }
        }
        return false;
    }
}