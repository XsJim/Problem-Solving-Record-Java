import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sumEvenAfterQueries(new int[] {1,2,3,4}, new int[][] {{1,0}, {-3,1}, {-4,0}, {2,3}})));
    }
}

class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];

        int sum = 0;
        for (int i = 0; i < A.length; i++) if (isEven(A[i])) sum += A[i];

        for (int i = 0; i < queries.length; i++) {
            if (isEven(A[queries[i][1]])) sum -= A[queries[i][1]];
            A[queries[i][1]] += queries[i][0];
            if (isEven(A[queries[i][1]])) sum += A[queries[i][1]];
            ans[i] = sum;
        }

        return ans;
    }

    private boolean isEven(int x) {
        return (x & 1) == 0;
    }
}