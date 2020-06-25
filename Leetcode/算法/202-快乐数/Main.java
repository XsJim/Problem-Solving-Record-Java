public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
        System.out.println(new Solution().isHappy(1047));
    }
}

class Solution {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        boolean[] map = new boolean[1000];
        if (n >= 1000) n = talgo(n);
        while (true) {
            if (n == 1) return true;
            if (map[n]) return false;
            map[n] = true;
            n = talgo(n);
        }
    }

    private static int talgo(int n) {
        int ans = 0;
        while (n != 0) {
            ans += Math.pow((n % 10), 2);
            n /= 10;
        }
        return ans;
    }
}