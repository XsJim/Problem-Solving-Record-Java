import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};
        new Solution().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int i = 0;
        int a = 0, b = 0;
        while (a < m && b < n) {
            if (nums1[a] < nums2[b]) temp[i++] = nums1[a++];
            else temp[i++] = nums2[b++];
        }

        while (a < m) temp[i++] = nums1[a++];
        while (b < n) temp[i++] = nums2[b++];
        i = 0;
        while (i < temp.length) nums1[i] = temp[i++];
    }
}