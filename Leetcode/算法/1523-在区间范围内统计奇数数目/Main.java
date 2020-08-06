public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countOdds(3, 7));
        System.out.println(new Solution().countOdds(8, 10));
    }
}

class Solution {
    // 观察可知：
    // 答案与两数之差的绝对值有关，设这个值为 x
    // 当 low 和 high 的奇偶性不同时， x 加 1 
    // 当两数都为奇数时， x 加 2
    // 否则， x 不变
    // 然后 x 除以 2 即可得到答案
    public int countOdds(int low, int high) {
        boolean a = ((low & 1) == 1);
        boolean b = ((high & 1) == 1);
        int ans = high - low;
        if (a ^ b) ans++;
        else if (a) {
            ans += 2;
        }

        return ans / 2;
    }
}