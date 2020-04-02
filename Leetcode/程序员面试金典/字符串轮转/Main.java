public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isFlipedString("waterbottle", "erbottlewat"));
        System.out.println(new Solution().isFlipedString("aa", "aba"));
    }
}

class Solution {
    public boolean isFlipedString(String s1, String s2) {
        return (s1.length() == s2.length()) && (s1+s1).contains(s2);
    }
}