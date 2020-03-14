public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(17));
        System.out.println(new Solution().findNthDigit(1000000000));
    }
}

class Solution {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        int i = 2;
        long j = 90;
        long m = 189;
        while (m < n) {
            i++;
            j *= 10;
            m += i * j;
        }
        long x = (long)Math.pow(10, i-1);
        long y = m - i * j + 1;
        long h = x + (n - y) / i;
        long hi = y + (h - x) * i;
        int re = (int)((h / Math.pow(10, (i-n+hi-1))) % 10);
        return re;
    }
}