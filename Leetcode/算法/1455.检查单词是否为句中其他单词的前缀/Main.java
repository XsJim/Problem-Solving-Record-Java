public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isPrefixOfWord("i love eating burger", "burg"));
        System.out.println(new Solution().isPrefixOfWord("this problem is an easy problem", "pro"));
        System.out.println(new Solution().isPrefixOfWord("i am tired", "you"));
        System.out.println(new Solution().isPrefixOfWord("i use triple pillow", "pill"));
        System.out.println(new Solution().isPrefixOfWord("hello from the other side", "they"));
    }
}

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        char[] s = sentence.toCharArray();
        char[] sw = searchWord.toCharArray();
        for (int i = 0, j = 1; i < s.length; i++, j++) {
            if (s[i] == sw[0]) {
                int z = 0;
                while (i < s.length && z < sw.length && s[i] == sw[z]) {
                    i++; z++;
                }
                if (z == sw.length) return j;
            }
            while (i < s.length && s[i] != ' ') i++;
        }
        return -1;
    }
}