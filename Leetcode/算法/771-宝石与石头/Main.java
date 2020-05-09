public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(new Solution().numJewelsInStones("z", "ZZ"));
    }
}

class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] a = new boolean[26];
        boolean[] A = new boolean[26];
        int lenJ = J.length()-1;
        while (lenJ >= 0) {
            char j = J.charAt(lenJ);
            if (j >= 'a' && j <= 'z') {
                a[j-'a'] = true;
            } else A[j-'A'] = true;
            lenJ--;
        }
        int sum = 0;
        int lenS = S.length()-1;
        while (lenS >= 0) {
            char s = S.charAt(lenS);
            if (s >= 'a' && s <= 'z' && a[s-'a']) sum++;
            else if (s >= 'A' && s <= 'Z' && A[s-'A']) sum++;
            lenS--;
        }
        return sum;
    }
}