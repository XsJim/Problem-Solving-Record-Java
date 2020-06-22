public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().hasAlternatingBits(5));
        System.out.println(new Solution().hasAlternatingBits(7));
        System.out.println(new Solution().hasAlternatingBits(11));
        System.out.println(new Solution().hasAlternatingBits(10));
    }
}

class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean prev = (n & 1) == 1 ? true : false;
        n >>= 1;
        while (n != 0) {
            if (((n & 1) == 1 ? true : false) == prev) return false;
            prev = !prev;
            n >>= 1;
        }
        return true;
    }
}