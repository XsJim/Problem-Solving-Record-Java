public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().arrangeCoins(5));
        System.out.println(new Solution().arrangeCoins(8));
        System.out.println(new Solution().arrangeCoins(1804289383));
    }
}

class Solution {
    // 模拟楼梯的摆放
    // 第一层放一个，逐次加一
    // 当当前层剩余的所有块少于等于当前层数时，说明已经不可以向后摆放，返回上一层的层数作为答案
    public int arrangeCoins(int n) {
        int x = 1;
        int sum = 0;
        while (x <= n) {
            n -= x;
            x++;
            sum++;
        }
        return sum;
    }
}