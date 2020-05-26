import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findTheDistanceValue(new int[] {4,5,8}, new int[] {10,9,1,8}, 2));
        System.out.println(new Solution().findTheDistanceValue(new int[] {1,4,2,3}, new int[] {-4,-3,6,10,20,30}, 3));
        System.out.println(new Solution().findTheDistanceValue(new int[] {2,1,100,3}, new int[] {-5,-2,10,-3,7}, 6));
    }
}

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            int x = lower_bound(arr2, arr1[i]);
            if (Math.abs(arr1[i]-arr2[x]) <= d) {
                sum++;
            } else {
                if (x - 1 >= 0 && Math.abs(arr1[i]-arr2[x-1]) <= d) sum++;
            }
        }
        return arr1.length-sum;
    }

    private static int lower_bound(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < k) left = mid + 1;
            else if (arr[mid] > k) right = mid - 1;
            else return mid;
        }
        if (left >= arr.length) return right;
        if (right < 0) return left;
        return left;
    }
}