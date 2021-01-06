public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countVowelStrings(1));
        System.out.println(new Solution().countVowelStrings(2));
        System.out.println(new Solution().countVowelStrings(33));
    }
}

//隔板法
class Solution {
    public int countVowelStrings(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }
}