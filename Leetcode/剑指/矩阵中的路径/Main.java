public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(new Solution().exist(new char[][] {{'a','b'},{'c','d'}}, "abcd"));
    }
}

class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || (board.length * board[0].length) < word.length()) return false;
        if (word.length() == 0) return true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] c = new boolean[board.length][board[i].length];
                    c[i][j] = true;
                    if (dfs(board, word, i, j, 1, new int[] {-1, 1, 0, 0}, new int[] {0, 0, -1, 1}, c)) return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int z, int[] a, int[] b, boolean[][] c) {
        if (z == word.length()) return true;
        for (int k = 0; k < 4; k++) {
            int ii = i + a[k];
            int jj = j + b[k];
            if (ii >= 0 && ii < board.length && jj >=0 && jj < board[ii].length && !c[ii][jj] && board[ii][jj] == word.charAt(z)) {
                c[ii][jj] = true;
                if (dfs(board, word, ii, jj, z+1, a, b, c)) return true;
                c[ii][jj] = false;
            }
        }
        return false;
    }
}