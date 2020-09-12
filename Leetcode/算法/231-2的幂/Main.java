public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(1));
        System.out.println(new Solution().isPowerOfTwo(16));
        System.out.println(new Solution().isPowerOfTwo(218));
    }
}

class Solution {
    // 枚举判断即可
    public boolean isPowerOfTwo(int n) {
        int x = 1;
        while (x > 0 && x <= Integer.MAX_VALUE) {
            if (x > n) return false;
            if (x == n) return true;
            x <<= 1;
        }
        return false;
    }
}