public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().sortString("aaaabbbbcccc"));
        System.out.println(new Solution().sortString("rat"));
        System.out.println(new Solution().sortString("leetcode"));
        System.out.println(new Solution().sortString("ggggggg"));
        System.out.println(new Solution().sortString("spo"));
    }
}

class Solution {
    public String sortString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int x = s.length();
        while (x != 0) {
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    count[i]--;
                    sb.append((char)(i+'a'));
                    x--;
                }
            }
            if (x == 0) break;
            for (int i = 25; i >= 0; i--) {
                if (count[i] != 0) {
                    count[i]--;
                    sb.append((char)(i+'a'));
                    x--;
                }
            }
        }
        return sb.toString();
    }
}