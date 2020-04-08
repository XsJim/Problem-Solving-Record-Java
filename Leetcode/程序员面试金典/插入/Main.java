public class Main {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(new Solution().insertBits(0b10000000000, 0b10011, 2, 6)));
        System.out.println(Integer.toBinaryString(new Solution().insertBits(0b0, 0b11111, 0, 4)));
        System.out.println(Integer.toBinaryString(new Solution().insertBits(0b0, 0b0, 0, 0)));
    }
}

class Solution {
    public int insertBits(int N, int M, int i, int j) {
        int ans = 0;
        for (int x = 0, z = 1, y; x < 32; N >>= 1, x++, z *= 2) {
            if (x >= i && x <= j) {
                y = (M & 1);
                M >>= 1;
            } else y = (N & 1);
            if (y == 1) ans += z;
        }
        return ans;
    }
}