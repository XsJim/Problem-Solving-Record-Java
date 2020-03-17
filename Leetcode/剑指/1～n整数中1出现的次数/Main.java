public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countDigitOne(12));
        System.out.println(new Solution().countDigitOne(13));
        System.out.println(new Solution().countDigitOne(1));
        System.out.println(new Solution().countDigitOne(9));
        System.out.println(new Solution().countDigitOne(100));
    }
}

class Solution {
    public int countDigitOne(int n) {
        int a, b, c;
        a = n / 10;
        b = n % 10;
        c = 0;
        int len = numLength(n);
        int sum = 0;
        for (int i = 0, j = 1; i < len; i++, j *= 10) {
            if (b == 0) sum += a * j;
            else if (b == 1) sum += (a * j + c + 1);
            else sum += (a + 1) * j;
            c += b * j;
            b = a % 10;
            a /= 10;
        }
        return sum;
    }

    private static int numLength(int n) {
        int re = 0;
        while (n != 0) {
            re++;
            n /= 10;
        }
        return re;
    }
}