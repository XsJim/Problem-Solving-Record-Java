public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().peakIndexInMountainArray(new int[] {0,1,0}));
        System.out.println(new Solution().peakIndexInMountainArray(new int[] {0,2,1,0}));
    }
}

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] < A[mid+1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}