import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().smallestDifference(new int[] {1, 3, 15, 11, 2}, new int[] {23, 127, 235, 19, 8}));
    }
}

class Solution {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long min = 	Long.MAX_VALUE;
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            long x = a[i] - b[j];
            if (x <= 0) {
                long y = Math.abs(x);
                if (y < min) min = y;
                i++;
            } else {
                if (x < min) min = x;
                j++;
            }
        }
        return (int)min;
    }
}