public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minSteps(3));
        System.out.println(new Solution().minSteps(1000));
    }
}

class Solution {
    // 每次都可以进行两种操作
    // 复制当前字符串，或者粘贴上次复制的字符串
    // 对于第一次来说，只有一个字符，且上次没有复制字符串，所以对于第一次来说，只能是复制的操作
    // 对于其他步骤：
    // 如果上次进行的是复制操作，那么当前就必须要进行粘贴操作，因为如果再次复制，复制结果和当前的复制字符串是一样的
    // 如果上次进行的是粘贴操作，那么当前既可以进行复制，也可以进行粘贴，这两种操作都会导致字符串的改变
    // 对于每一次递归，都要先判断当前字符串的长度是否已经超出预定字符串的长度
    // 其次，再判断是否等于预定字符串长度，如果等于，即可判断其构造次数是否小于当前最小值
    // 如果没有从以上条件退出递归，则说明当前字符串长度还小于预定长度
    // 这时，要先判断一下当前已经用过的构造次数是否已经超过当前最小值，如果是，则应该立即结束向下递归，达到剪枝的目的
    // 如果依然通过条件，则可以继续程序的核心部分
    public int minSteps(int n) {
        if (n == 1) return 0;
        int[] min = new int[] {Integer.MAX_VALUE};
        talgo(1, 1, n, 1, min, false);
        return min[0];
    }

    private static void talgo(int current, int p, int n, int x, int[] min, boolean flag) {
        if (current > n) return;
        if (current == n) {
            if (x < min[0]) min[0] = x;
            return;
        }
        if (x > min[0]) return;
        if (flag) talgo(current, current, n, x+1, min, false);
        talgo(current+p, p, n, x+1, min, true);
    }
}