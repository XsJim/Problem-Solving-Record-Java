public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().getSum(1, 2));
        System.out.println(new Solution().getSum(-2, 3));
        System.out.println(new Solution().getSum(-2, -3));
        System.out.println(new Solution().getSum(-1, 1));
    }
}

class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int c = a;
            a ^= b;
            b &= c;
            b <<= 1;
        }
        return a;
    }
}