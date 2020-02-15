public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().fib(0));
        System.out.println(new Solution().fib(1));
        System.out.println(new Solution().fib(2));
        System.out.println(new Solution().fib(5));
        System.out.println(new Solution().fib(50));
        System.out.println(new Solution().fib(99));
        System.out.println(new Solution().fib(100));
    }
}

class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 2, b = 1, c = 1;
        while (a < n) {
            int d = (b + c) % 1000000007;
            b = c;
            c = d;
            a++;
        }
        return c;
    }
}