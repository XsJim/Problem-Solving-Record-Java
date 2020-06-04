import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(new int[] {3,1,2,4})));
    }
}

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0, j = 0, z = A.length - 1; i < A.length; i++) {
            if ((A[i] & 1) == 1) B[z--] = A[i];
            else B[j++] = A[i];
        }
        return B;
    }
}