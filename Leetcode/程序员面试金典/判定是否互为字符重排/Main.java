public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().CheckPermutation("abc", "bca"));
        System.out.println(new Solution().CheckPermutation("abc", "bad"));
    }
}

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 0 && s2.length() == 0) return true;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int R = 256;
        int[] flag1 = new int[R];
        int[] flag2 = new int[R];
        for (int i = 0; i < chars1.length; i++) {
            flag1[chars1[i]]++;
            flag2[chars2[i]]++;
        }
        for (int i = 0; i < R; i++) {
            if (flag1[i] != flag2[i]) return false;
        }
        return true;
    }
}