import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(1)));
        System.out.println(Arrays.toString(new Solution().twoSum(2)));
        System.out.println(Arrays.toString(new Solution().twoSum(11)));
    }
}


class Solution {
    public double[] twoSum(int n) {
        int[] count = new int[6*n];
        talgo(count, 0, 0, n);
        double sum = 0;
        int num = 0;
        for (int i = 0; i < 6*n; i++) {
            if (count[i] != 0) {
                num++;
                sum += count[i];
            }
        }
        double[] re = new double[num];
        for (int i = 0, j = 0; i < 6*n; i++) {
            if (count[i] != 0) {
                re[j++] = count[i] / sum;
            }
        }
        return re;
    }

    private static void talgo(int[] count, int i, int sum, int n) {
        if (i > n) return;
        if (i == n) {
            count[sum-1]++;
            return;
        }
        for (int j = 1; j <= 6; j++) {
            talgo(count, i+1, sum+j, n);
        }
    }
}