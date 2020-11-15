public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().smallestRangeI(new int[] {1}, 0));
        System.out.println(new Solution().smallestRangeI(new int[] {0, 10}, 2));
        System.out.println(new Solution().smallestRangeI(new int[] {1, 3, 6}, 3));
    }
}

class Solution {
    public int smallestRangeI(int[] A, int K) {
        int max = A[0];
        int min = A[0];
        for (int x : A) {
            max = Math.max(x, max);
            min = Math.min(x, min);
        }

        return Math.max(0, max - min - 2 * K);
    }
}