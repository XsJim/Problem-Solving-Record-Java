public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minFlips(2, 6, 5));
        System.out.println(new Solution().minFlips(4, 2, 7));
        System.out.println(new Solution().minFlips(1, 2, 3));
    }
}

class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0; int z = Math.max(a, Math.max(b, c));
        while (z != 0) {
            if ((c & 1) == 0) {
                int x = a & 1, y = b & 1;
                if (x == 1 && y == 1) ans += 2;
                else if (x == 1 || y == 1) ans +=1;
            } else if ((a & 1) == 0 && (b & 1) == 0) ans += 1;
            a >>= 1; b >>= 1; c >>= 1; z >>= 1;
        }
        return ans;
    }
}