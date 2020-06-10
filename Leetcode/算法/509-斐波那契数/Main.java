public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().fib(2));
        System.out.println(new Solution().fib(3));
        System.out.println(new Solution().fib(4));
        System.out.println(new Solution().fib(30));
    }
}

class Solution {
    public int fib(int N) {
        if (N < 2) return N;
        int a = 1, b = 1, c;
        while (N-- > 2) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}