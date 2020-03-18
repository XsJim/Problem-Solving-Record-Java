public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isUnique("leetcode"));
        System.out.println(new Solution().isUnique("abc"));
        System.out.println(new Solution().isUnique("acdfgc"));
    }
}

class Solution {
    public boolean isUnique(String astr) {
        int flag = 0;
        char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (((flag >> (chars[i]-'0')) & 1) == 1) {
                return false;
            }
            flag |= (1 << (chars[i]-'0'));
        }
        return true;
    }
}