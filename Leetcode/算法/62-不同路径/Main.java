public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(2, 2));
        System.out.println(new Solution().uniquePaths(3, 2));
        System.out.println(new Solution().uniquePaths(7, 3));
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        int[] x = new int[n]; x[0] = 1;
        while (m > 0) {
            for (int i = 1; i < n; i++) x[i] += x[i-1];
            m--;
        }
        return x[n-1];
    }
}