import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findContentChildren(new int[] {1,2,3}, new int[] {1,1}));
        System.out.println(new Solution().findContentChildren(new int[] {1,2}, new int[] {1,2,3}));
    }
}

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        int sum = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;  sum++;
            }
            j++;
        }

        return sum;
    }
}