public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().canConstruct("a", "b"));
        System.out.println(new Solution().canConstruct("aa", "ab"));
        System.out.println(new Solution().canConstruct("ab", "aab"));
    }
}

class Solution {
    // 给定两个字符串 A, B ，判断 A 是否能够由 B 中字符组成
    // 就是判断 A 中的每个字符是否在 B 中出现，并且 B 中出现的次数大于等于 A 中出现次数
    // 首先统计 B 中字符，然后统计 A 中字符，最后按照上述条件进行对比即可
    public boolean canConstruct(String ransomNote, String magazine) {
        int R = 26; char x = 'a';

        int[] count = new int[R];
        for (int i = 0; i < magazine.length(); i++) count[magazine.charAt(i)-x]++;
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--count[ransomNote.charAt(i)-x] < 0) return false;
        }

        return true;
    }
}