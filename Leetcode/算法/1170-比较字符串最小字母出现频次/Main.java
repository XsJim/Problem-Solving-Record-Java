import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().numSmallerByFrequency(new String[] {"cbd"}, new String[] {"zaaaz"})));
        System.out.println(Arrays.toString(new Solution().numSmallerByFrequency(new String[] {"bbb","cc"}, new String[] {"a","aa","aaa","aaaa"})));
    }
}

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int R = 11;
        int[] count = new int[R];
        for (int i = 0; i < words.length; i++) count[f(words[i])]++;
        for (int i = R - 1, prev = 0; i > 0; i--) {
            int temp = count[i];
            count[i] = prev;
            prev += temp;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = count[f(queries[i])];
        }
        return ans;
    }

    private static int f(String s) {
        int[] count = new int[26];
        for (char x : s.toCharArray()) count[x-'a']++;
        for (int i = 0; i < 26; i++) if (count[i] != 0) return count[i];
        return -1;
    }
}