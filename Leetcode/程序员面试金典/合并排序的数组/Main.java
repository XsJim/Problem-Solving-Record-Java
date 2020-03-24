import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,0,0,0};
        int[] B = new int[] {2,5,6};
        new Solution().merge(A, 3, B, 3);
        System.out.println(Arrays.toString(A));
    }
}

class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        if (n == 0) return;
        int a = m - 1, b = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (a < 0) A[i] = B[b--];
            else if (b < 0) A[i] = A[a--];
            else if (A[a] < B[b]) A[i] = B[b--];
            else A[i] = A[a--];
        }
    }
}