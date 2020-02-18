public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.00000, 10));
        System.out.println(new Solution().myPow(2.10000, 3));
        System.out.println(new Solution().myPow(2.00000, -2));
    }
}

class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) return 1;
        if (x == 0) return 0;
        boolean flag_1 = x >= 0 ? false : true;
        if (flag_1) x = Math.abs(x);
        boolean flag_2 = n >= 0 ? false : true;
        if (flag_2) n = Math.abs(n);
        boolean flag_3 = ((n & 1) == 1) ? true : false;
        double re = 1;
        while (n != 0) {
            if ((n & 1) == 1) re *= x;
            n >>>= 1;
            x *= x;
        }
        if (flag_2) re = 1 / re;
        if (flag_1 && flag_3) re *= -1;
        return re;
    }
}