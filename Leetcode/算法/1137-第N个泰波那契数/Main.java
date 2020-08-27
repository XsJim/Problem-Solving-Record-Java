public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().tribonacci(4));
        System.out.println(new Solution().tribonacci(25));
        System.out.println(new Solution().tribonacci(37));
    }
}

class Solution {
    // 循环计算即可
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int a = 0, b = 1, c = 1;
        while (n > 2) {
            int temp = a + b + c;
            a = b;
            b = c;
            c = temp;
            n--;
        }

        return c;
    }
}