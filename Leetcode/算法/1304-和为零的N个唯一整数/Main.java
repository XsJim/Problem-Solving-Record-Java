import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sumZero(5)));
        System.out.println(Arrays.toString(new Solution().sumZero(4)));
        System.out.println(Arrays.toString(new Solution().sumZero(3)));
        System.out.println(Arrays.toString(new Solution().sumZero(1)));
    }
}

class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int i = 0;
        int mid = n / 2;
        for (int j = 1; i < mid; j++) {
            ans[i++] = j;
        }
        if ((n & 1) == 1) ans[i++] = 0;
        for (int j = -1; i < n; j--) {
            ans[i++] = j;
        }
        return ans;
    }
}