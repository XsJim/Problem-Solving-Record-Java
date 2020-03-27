public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().waysToStep(5));
        System.out.println(new Solution().waysToStep(61));
        System.out.println(new Solution().waysToStep(1000000));
    }
}

class Solution {
    public int waysToStep(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int a = 2, b = 4, c = 7;
        for (int i = 4, d; i < n; i++) {
            d = (a + b) % 1000000007;
            d = (d + c) % 1000000007;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }
}