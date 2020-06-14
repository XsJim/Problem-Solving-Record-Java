public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new String[] {"abcw","baz","foo","bar","xtfn","abcdef"}));
        System.out.println(new Solution().maxProduct(new String[] {"a","ab","abc","d","cd","bcd","abcd"}));
        System.out.println(new Solution().maxProduct(new String[] {"a","aa","aaa","aaaa"}));
    }
}

class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] flag = new int[len];
        for (int i = 0; i < len; i++) {
            for (char c : words[i].toCharArray()) {
                flag[i] |= (1 << (c - 'a'));
            }
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((flag[i] & flag[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }

        return max;
    }
}