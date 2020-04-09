import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().divingBoard(1, 2, 3)));
        System.out.println(Arrays.toString(new Solution().divingBoard(11, 16, 20)));
        System.out.println(Arrays.toString(new Solution().divingBoard(11, 16, 0)));
        System.out.println(Arrays.toString(new Solution().divingBoard(11, 11, 100000)));
    }
}

class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[] {shorter*k};
        int[] ans = new int[k+1];
        for (int i = 0, sum = shorter * k; i <= k; i++) {
            ans[i] = sum;
            sum -= shorter;
            sum += longer;
        }
        return ans;
    }
}