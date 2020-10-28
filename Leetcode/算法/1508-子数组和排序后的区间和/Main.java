import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().rangeSum(new int[] {1,2,3,4}, 4, 1, 5));
        System.out.println(new Solution().rangeSum(new int[] {1,2,3,4}, 4, 3, 4));
        System.out.println(new Solution().rangeSum(new int[] {1,2,3,4}, 4, 1, 10));
    }
}

// 首先得到目标数组（使用前缀数组和），然后排序，然后计算区间和得到答案
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] sum = new int[n * (n + 1) / 2];
        int x = 0;
        int[] a = new int[nums.length];
        a[0] = nums[0];
        sum[x++] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[x++] = nums[i];
            a[i] = a[i-1] + nums[i];
        }

        for (int i = 1; i < a.length; i++) {
            sum[x++] = a[i];
            for (int j = 0; j < i - 1; j++) {
                sum[x++] = a[i] - a[j];
            }
        }

        Arrays.sort(sum);
        int ans = 0;
        for (int i = left - 1; i < right; i++) {
            ans += sum[i];
            ans %= 1000000007;
        }

        return ans;
    }
}