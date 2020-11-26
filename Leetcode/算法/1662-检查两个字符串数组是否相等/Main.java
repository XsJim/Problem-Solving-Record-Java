public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().arrayStringsAreEqual(new String[] {"ab", "c"}, new String[] {"a", "bc"}));
        System.out.println(new Solution().arrayStringsAreEqual(new String[] {"a", "cb"}, new String[] {"ab", "c"}));
        System.out.println(new Solution().arrayStringsAreEqual(new String[] {"abc", "d", "defg"}, new String[] {"abcddefg"}));
    }
}

// 遍历两个字符串数组依序对比即可
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0;
        int ii = 0, jj = 0;
        while (i < word1.length && j < word2.length) {
            while (ii < word1[i].length() && jj < word2[j].length()) {
                if (word1[i].charAt(ii) != word2[j].charAt(jj)) return false;
                ii++;
                jj++;
            } 
            if (ii == word1[i].length()) {
                ii = 0;
                i++;
            }
            if (jj == word2[j].length()) {
                jj = 0;
                j++;
            }
        }

        if (i < word1.length || j < word2.length) return false;
        return true;
    }
}