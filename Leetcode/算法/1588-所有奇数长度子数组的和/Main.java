public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().sumOddLengthSubarrays(new int[] {1,4,2,5,3}));
        System.out.println(new Solution().sumOddLengthSubarrays(new int[] {1,2}));
        System.out.println(new Solution().sumOddLengthSubarrays(new int[] {10,11,12}));
    }
}

class Solution {
    // 首先，计算前缀数组和，即新建数组，每一位都对应原数组中，当前元素和所有它之前的元素的和
    // 然后，枚举奇数子数组的长度，并循环计算所有子数组的和，通过新建的前缀和数组，可以快速得出当前子数组的和
    public int sumOddLengthSubarrays(int[] arr) {
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + arr[i];
        }
        int ans = sum[sum.length-1];

        for (int i = 3; i <= arr.length; i += 2) {
            for (int j = 0; j + i <= arr.length; j++) {
                ans += sum[j+i-1] - sum[j] + arr[j];
            }
        }

        return ans;
    }
}