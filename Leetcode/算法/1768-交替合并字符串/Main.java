public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().mergeAlternately("abc", "pqr"));
        System.out.println(new Solution().mergeAlternately("ab", "pqrs"));
        System.out.println(new Solution().mergeAlternately("abcd", "pq"));
    }
}

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int len1 = word1.length(), len2 = word2.length();

        int minLen = Math.min(len1, len2);

        for (int i = 0; i < minLen; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        for (int i = minLen; i < len1; i++) {
            sb.append(word1.charAt(i));
        }

        
        for (int i = minLen; i < len2; i++) {
            sb.append(word2.charAt(i));
        }

        return sb.toString();
    }
}