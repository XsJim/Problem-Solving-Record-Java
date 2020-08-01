import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().largestPerimeter(new int[] {2,1,2}));
        System.out.println(new Solution().largestPerimeter(new int[] {1,2,1}));
        System.out.println(new Solution().largestPerimeter(new int[] {3,2,3,4}));
        System.out.println(new Solution().largestPerimeter(new int[] {3,6,2,3}));
    }
}

class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);

        for (int i = A.length - 1; i > 1; i--) {
            int j = i - 1; int z = i - 2;

            if (A[i] < A[j] + A[z]) return A[i] + A[j] + A[z];
        }
        return 0;
    }
}