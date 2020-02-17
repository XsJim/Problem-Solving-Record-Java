import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        for (int i = 2; i <= 1000; i++) {
            System.out.println(i + ":" + new Solution().cuttingRope(i));
        }
    }
}

class Solution {
    public int cuttingRope(int n) {
        return talgo_2(n);
    }
    /**
     * 动态规划，使用大数值类存放计算结果
     * @param n 拆分前的长度
     * @return 拆分后得到的最大乘积
     */
    private static int talgo_2(int n) {
        BigInteger[] a = new BigInteger[n+1];
        for (int i = 0; i <= n; i++) {
            a[i] = BigInteger.valueOf(0);
        }
        a[1] = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                BigInteger e = BigInteger.valueOf(j);
                a[i] = tmax(a[i], tmax(e.multiply(BigInteger.valueOf(i - j)), e.multiply(a[i-j])));
            }
        }
        return a[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }

    private static BigInteger tmax(BigInteger a, BigInteger b) {
        if (a.compareTo(b) >= 0) return a;
        else return b;
    }
}