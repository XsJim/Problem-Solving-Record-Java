public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().rotatedDigits(10));
    }
}

class Solution {
    private static int[] map = new int[] {0,1,5,-1,-1,2,9,-1,8,6};

    public int rotatedDigits(int N) {
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            int j = talgo(i);
            if (j != -1 && j != i) {
                ans++;
            }
        }
        return ans;
    }

    private static int talgo(int x) {
        int ans = 0, j = 1;
        while (x != 0) {
            int i = x % 10;
            if (map[i] == -1) return -1;
            ans += map[i] * j;
            j *= 10;
            x /= 10;
        }
        return ans;
    }
}