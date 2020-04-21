import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findClosedNumbers(2)));
        System.out.println(Arrays.toString(new Solution().findClosedNumbers(1837591841)));
    }
}

class Solution {
    public int[] findClosedNumbers(int num) {
        int x = count(num);
        int[] ans = new int[] {-1, -1};
        for (int i = num + 1; i > 0 && i <= 2147483647; i++) {
            if (count(i) == x) {
                ans[0] = i;
                break;
            }
        }

        for (int i = num - 1; i > 0; i--) {
            if (count(i) == x) {
                ans[1] = i;
                break;
            }
        }

        return ans;
    }

    private static int count(int num) {
        int n = 0;
        while (num != 0) {
            num &= (num - 1);
            n++;
        }
        return n;
    }
}