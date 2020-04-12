public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().getKthMagicNumber(5));
    }
}

class Solution {
    public int getKthMagicNumber(int k) {
        int[] ans = new int[k];
        ans[0] = 1;
        int x = 0, y = 0, z = 0;
        for (int i = 1; i < k; i++) {
            ans[i] = Math.min(ans[x]*3, Math.min(ans[y]*5, ans[z]*7));
            if (ans[i] == ans[x]*3) x++;
            if (ans[i] == ans[y]*5) y++;
            if (ans[i] == ans[z]*7) z++;
        }
        return ans[k-1];
    }
}