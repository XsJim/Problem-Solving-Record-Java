public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().detectCapitalUse("USA"));
        System.out.println(new Solution().detectCapitalUse("FlaG"));
        System.out.println(new Solution().detectCapitalUse("Flaa"));
        System.out.println(new Solution().detectCapitalUse("waHaha"));
    }
}

class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) return false;
        if (word.length() == 1) return true;
        char[] sArr = word.toCharArray();

        boolean ans = true;
        char l, r;
        if (sArr[1] >= 'a' && sArr[1] <= 'z') {
            l = 'a'; r = 'z';
        } else {
            if (sArr[0] >= 'a' && sArr[0] <= 'z') return false;
            l = 'A'; r = 'Z';
        }

        for (int i = 2; i < sArr.length; i++) {
            if (!(sArr[i] >= l && sArr[i] <= r)) {
                return false;
            }
        }
        return true;
    }
}