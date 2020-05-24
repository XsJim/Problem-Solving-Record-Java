public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minAddToMakeValid("())"));
        System.out.println(new Solution().minAddToMakeValid("((("));
        System.out.println(new Solution().minAddToMakeValid("()"));
        System.out.println(new Solution().minAddToMakeValid("()))(("));
    }
}

class Solution {
    public int minAddToMakeValid(String S) {
        int l = 0, r = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                l++;
            } else {
                if (l != 0) l--;
                else r++;
            }
        }
        return l+r;
    }
}