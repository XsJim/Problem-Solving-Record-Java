public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
        System.out.println(new Solution().isAnagram("rat", "car"));
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int R = 256;
        int[] count = new int[R];
        for (char x : s.toCharArray()) count[x]++;
        for (char x : t.toCharArray()) count[x]--;
        for (int i = 0; i < R; i++) if (count[i] != 0) return false;
        return true;
    }
}