public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numOfSubarrays(new int[] {2,2,2,2,5,5,5,8}, 3, 4));
        System.out.println(new Solution().numOfSubarrays(new int[] {1,1,1,1,1}, 1, 0));
        System.out.println(new Solution().numOfSubarrays(new int[] {11,13,17,23,29,31,7,5,2,3}, 3, 5));
        System.out.println(new Solution().numOfSubarrays(new int[] {7,7,7,7,7,7,7}, 7, 7));
        System.out.println(new Solution().numOfSubarrays(new int[] {4,4,4,4}, 4, 1));
    }
}

class Solution {
    // 使用前缀和数组快速计算区间和，从而计算出平均值
    // 判断每个平均值是否超过或等于阈值即可
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int[] sum = new int[arr.length+1];
        int i = arr.length-1;
        sum[i] = arr[i];
        i--;
        while (i >= 0) {
            sum[i] = sum[i+1] + arr[i];
            i--;
        }
        int ans = 0;
        i = 0;
        while (i < arr.length) {
            int x = i + k;
            if (x <= arr.length) {
                ans += ((sum[i] - sum[x]) / k >= threshold) ? 1 : 0;
            } else break;
            i++;
        }

        return ans;
    }
}