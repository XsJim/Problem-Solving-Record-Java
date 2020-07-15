public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("egg", "add"));
        System.out.println(new Solution().isIsomorphic("foo", "bar"));
        System.out.println(new Solution().isIsomorphic("paper", "title"));
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] map = new char[256];
        boolean[] flag = new boolean[256];

        char[] mapB = new char[256];
        boolean[] flagB = new boolean[256];

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        for (int i = 0; i < sArr.length; i++) {
            if (flag[sArr[i]] ^ flagB[tArr[i]]) return false;
            if (flag[sArr[i]]) {
                if (map[sArr[i]] != tArr[i] || mapB[tArr[i]] != sArr[i]) return false;
            } else {
                map[sArr[i]] = tArr[i];
                flag[sArr[i]] = true;
                mapB[tArr[i]] = sArr[i];
                flagB[tArr[i]] = true;
            }
        }

        return true;
    }
}