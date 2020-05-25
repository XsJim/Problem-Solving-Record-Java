import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().diStringMatch("IDID")));
        System.out.println(Arrays.toString(new Solution().diStringMatch("III")));
        System.out.println(Arrays.toString(new Solution().diStringMatch("DDI")));
    }
}

class Solution {
    public int[] diStringMatch(String S) {
        int[] ans = new int[S.length()+1];
        int l = 0, r = S.length(), i = 0;
        for (char c : S.toCharArray()) {
            if (c == 'I') ans[i++] = l++;
            else ans[i++] = r--;
        }
        ans[i] = l;
        return ans;
    }
}