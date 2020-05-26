import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortedSquares(new int[] {-4,-1,0,3,10})));
        System.out.println(Arrays.toString(new Solution().sortedSquares(new int[] {-7,-3,2,3,11})));
    }
}

class Solution {
    public int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];
        int i = A.length - 1, j = 0, z = A.length - 1;
        while (i >= 0) {
            int left = A[j] * A[j];
            int right = A[z] * A[z];
            if (left > right) {
                B[i--] = left;
                j++;
            } else {
                B[i--] = right;
                z--;
            }
        }
        return B;
    }
}