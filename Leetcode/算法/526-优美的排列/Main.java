public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) System.out.println(new Solution().countArrangement(i));
    }
}

class Solution {
    public int countArrangement(int N) {
        int[] ans = new int[1];
        talgo(new boolean[N], ans, 0, N);
        return ans[0];
    }

    private static void talgo(boolean[] flag, int[] ans, int x, int N) {
        if (x == N) {
            ans[0]++;
            return;
        }
        x++;
        for (int i = 1; i <= N; i++) {
            if (!flag[i-1] && ((x % i == 0) || (i % x == 0))) {
                flag[i-1] = true;
                talgo(flag, ans, x, N);
                flag[i-1] = false;
            }
        }
    }
}