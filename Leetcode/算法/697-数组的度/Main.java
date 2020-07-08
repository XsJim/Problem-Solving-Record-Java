public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findShortestSubArray(new int[] {1, 2, 2, 3, 1}));
        System.out.println(new Solution().findShortestSubArray(new int[] {1,2,2,3,1,4,2}));
        System.out.println(new Solution().findShortestSubArray(new int[] {1}));
    }
}

class Solution {
    public int findShortestSubArray(int[] nums) {
        int R = 50000;
        int[] a = new int[R];
        int[] b = new int[R];
        int[] c = new int[R];

        for (int i = 0; i < nums.length; i++) {
            a[nums[i]]++;
            if (b[nums[i]] == 0) {
                b[nums[i]] = i + 1;
                c[nums[i]] = i + 1;
            }
            else c[nums[i]] = i + 1;
        }

        int max = Integer.MIN_VALUE;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0, sum = 0; i < R; i++) {
            if (a[i] != 0) {
                if (a[i] > max) {
                    max = a[i];
                    minLen = c[i] - b[i] + 1;
                }
                else if (a[i] == max) {
                    minLen = Math.min(minLen, c[i] - b[i] + 1);
                }
                sum += a[i];
                if (sum == nums.length) break;
            }
        }

        return minLen;
    }
}