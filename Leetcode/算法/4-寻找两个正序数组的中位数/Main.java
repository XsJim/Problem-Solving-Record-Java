public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
        System.out.println(new Solution().findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
    }
}

class Solution {
    // nums1 表示较短的数组， nums2 表示较长的数组
    // 根据数组长度确定分割线左边的元素个数（总长度为偶数，左右个数相同，为奇数，左边比右边多一个）
    // 使用二分算法枚举分割线在 nums1 中可能的位置
    // 得到 nums1 的分割线位置，用左半部分总长度减去这个位置值，得到就是 nums2 的分割线的位置
    // 如果 nums1 中分割线左边的值大于 nums2 分割线右边的值，说明当前 nums1 分割线的值过大，应该减小右边界的值
    // 反之 则说明当前 nums1 分割线的值过小，应该增大左边界的值
    // 退出循环时，一定有条件 left == right 成立
    // 这时 nums1 中分割线的位置为 left 或 right
    // 那么 nums2 中分割线的位置即为总长 leftLen 减去 left 或 right
    // 最终，如果两数组总长值为奇数，则中位数为分割线1、2左边的两个数中，较大的那一个
    // 如果为偶数，则中位数为分割线1、2左边两个数的较大值，加右边两个数的较小值的和除以 2
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int len1 = nums1.length;
        int len2 = nums2.length;

        int leftLen = (len1 + len2 + 1) / 2;

        int left = 0, right = len1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            int mid2 = leftLen - mid;
            if (nums1[mid-1] > nums2[mid2]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        int mid1 = left;
        int mid2 = leftLen - mid1;

        int nums1Left = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1-1];
        int nums1Right = mid1 == len1 ? Integer.MAX_VALUE : nums1[mid1];
        int nums2Left = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2-1];
        int nums2Right = mid2 == len2 ? Integer.MAX_VALUE : nums2[mid2];

        if (((len1 + len2) & 1) == 1) {
            return Math.max(nums1Left, nums2Left);
        }

        return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
    }
}