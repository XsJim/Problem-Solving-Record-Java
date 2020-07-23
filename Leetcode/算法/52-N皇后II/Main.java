public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().totalNQueens(4));
        System.out.println(new Solution().totalNQueens(8));
    }
}

class Solution {
    public int totalNQueens(int n) {
        int[] ans = new int[1];
        talgo(0, n, new boolean[n], new boolean[2*n-1], new boolean[2*n-1], ans);
        return ans[0];
    }

    private static void talgo(int x, int n, boolean[] yF, boolean[] lF, boolean[] rF, int[] ans) {
        if (x == n) {
            ans[0]++;
            return;
        }
        int nn = n - 1;
        for (int i = 0; i < n; i++) {
            if (!yF[i] && !lF[x-i+nn] && !rF[x+i]) {
                yF[i] = true; lF[x-i+nn] = true; rF[x+i] = true;
                talgo(x+1, n, yF, lF, rF, ans);
                yF[i] = false; lF[x-i+nn] = false; rF[x+i] = false;
            }
        }
    }
}