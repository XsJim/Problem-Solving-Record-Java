public class Main {
    public static void main(String[] args) {        
        System.out.println(new Solution().findTheDifference("abcd", "abcde"));
        System.out.println(new Solution().findTheDifference("", "y"));
        System.out.println(new Solution().findTheDifference("a", "aa"));
    }
}

class Solution {
    public char findTheDifference(String s, String t) {
        int a = 0;
        for (char x : s.toCharArray()) a ^= x;
        for (char x : t.toCharArray()) a ^= x;
        return (char)a;
    }
}