public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numWays(0));
        System.out.println(new Solution().numWays(1));
        System.out.println(new Solution().numWays(2));
        System.out.println(new Solution().numWays(5));
        System.out.println(new Solution().numWays(50));
        System.out.println(new Solution().numWays(99));
        System.out.println(new Solution().numWays(100));
    }
}

class Solution {
    public int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        int a = 2, b = 1, c = 2;
        while (a < n) {
            int d = (b + c) % 1000000007;
            b = c;
            c = d;
            a++;
        }
        return c;
    }
}