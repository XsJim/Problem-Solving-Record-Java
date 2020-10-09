public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(3));
        System.out.println(new Solution().minOperations(6));
    }
}

class Solution {
    // 目的是让所有的数变为给定的数，求最小的改变次数
    // 通过观察，总的变化次数就是从 1 开始，直到最大的小于给定 n 的数，每个数和给定 n 的差的和
    // 通过化简公式，最终只需要计算一个等差数列的前 n 项和即可
    // 对于给定的 n
    // 项数 x 是 n / 2 下取整
    // 首项根据 n 的奇偶而不同，奇为 2 ，偶为 1
    // 等差 d 为 2
    // 得到所需值之后，直接通过前 n 项和公式计算返回答案即可
    public int minOperations(int n) {
        int ans = (n & 1) == 1 ? 2 : 1;
        n = n / 2;
        ans = n * (ans + n - 1);
        return ans;
    }
}