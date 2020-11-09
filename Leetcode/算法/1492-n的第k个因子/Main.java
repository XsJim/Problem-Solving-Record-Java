public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().kthFactor(12, 3));
        System.out.println(new Solution().kthFactor(7, 2));
        System.out.println(new Solution().kthFactor(4, 4));
        System.out.println(new Solution().kthFactor(1, 1));
        System.out.println(new Solution().kthFactor(1000, 3));
    }
}

// 循环每一个可能的因子，如果确定是因子，就将计数器加 1
// 当计数器达到 k 时，返回当前的因子
// 退出循环后，说明因子数量达不到给定条件，所以返回 -1
class Solution {
    public int kthFactor(int n, int k) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (count == k) return i;
            }
        }
        return -1;
    }
}