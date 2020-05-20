public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numTilePossibilities("AAB"));
        System.out.println(new Solution().numTilePossibilities("AAABBC"));
    }
}

class Solution {
    public int numTilePossibilities(String tiles) {
        int[] book = new int[26];
        for (char c : tiles.toCharArray()) {
            book[c-'A']++;
        }
        int[] ans = new int[] {0};
        talgo(ans, book);
        return ans[0];
    }

    private static void talgo(int[] ans, int[] book) {
        for (int i = 0; i < 26; i++) {
            if (book[i] > 0) {
                book[i]--;
                ans[0]++;
                talgo(ans, book);
                book[i]++;
            }
        }
    }
}