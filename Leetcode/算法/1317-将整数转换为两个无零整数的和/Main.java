import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getNoZeroIntegers(2)));
        System.out.println(Arrays.toString(new Solution().getNoZeroIntegers(11)));
        System.out.println(Arrays.toString(new Solution().getNoZeroIntegers(10000)));
        System.out.println(Arrays.toString(new Solution().getNoZeroIntegers(69)));
        System.out.println(Arrays.toString(new Solution().getNoZeroIntegers(1010)));
    }
}

class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        ans[0] = 1; ans[1] = n - 1;
        while (true) {
            if (check(ans[0]) && check(ans[1])) break;
            ans[0]++; ans[1]--; 
        }
        return ans;
    }

    private static boolean check(int x) {
        while (x != 0) {
            if (x % 10 == 0) return false;
            x /= 10;
        }
        return true;
    }
}