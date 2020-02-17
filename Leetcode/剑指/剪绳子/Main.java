public class Main {
    public static void main(String[] args) {
        for (int i = 2; i <= 58; i++) {
            System.out.println(i + ":" + new Solution().cuttingRope(i));
        }
    }
}

class Solution {
    public int cuttingRope(int n) {
        return talgo_2(n);
    }

    /**
     * 暴力搜索
     * @param n 拆分前的长度
     * @return 拆分后得到的最大乘积
     */
    public static int talgo_1(int n) {
        if (n == 1) return 1;
        int re = -1;
        for (int i = 1; i <= n - 1; i++) {
            int b = i * (n - i);
            int c = i * talgo_1(n-i);
            int a = b > c ? b : c;
            re = re > a ? re : a;
        }
        return re;
    }

    /**
     * 动态规划
     * @param n 拆分前的长度
     * @return 拆分后得到的最大乘积
     */
    private static int talgo_2(int n) {
        int[] a = new int[n+1];
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                int b = j * (i - j);
                int c = j * a[i-j];
                int d = b > c ? b : c;
                a[i] = a[i] > d ? a[i] : d;
            }
        }
        return a[n];
    }
}