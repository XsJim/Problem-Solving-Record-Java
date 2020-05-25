public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().generateTheString(4));
        System.out.println(new Solution().generateTheString(2));
        System.out.println(new Solution().generateTheString(7));
    }
}

class Solution {
    public String generateTheString(int n) {
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) ans[i] = 'b';
        if ((n & 1) == 0) ans[0] = 'a';
        return String.valueOf(ans);
    }
}