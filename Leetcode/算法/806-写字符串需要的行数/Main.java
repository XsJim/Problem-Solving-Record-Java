import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().numberOfLines(new int[] {10,10,10,10,10,10,10,10,10,10,10,
          10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "abcdefghijklmnopqrstuvwxyz")));
        System.out.println(Arrays.toString(new Solution().numberOfLines(new int[] {4,10,10,10,10,10,10,10,10,10,10,
          10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "bbbcccdddaaa")));
    }
}

class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int[] ans = new int[2];
        ans[0] = 1;
        for (char c : S.toCharArray()) {
            int x = widths[c-'a'];
            if (ans[1] + x > 100) {
                ans[0]++; ans[1] = 0;
            }
            ans[1] += x;
        }
        return ans;
    }
}