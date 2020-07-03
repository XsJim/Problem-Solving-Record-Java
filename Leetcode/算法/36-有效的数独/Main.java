public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isValidSudoku(new char[][] {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}}));

        System.out.println(new Solution().isValidSudoku(new char[][] {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}}));
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] flag = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (flag[num]) return false;
                    flag[num] = true;
                }
                
            }
        }
        for (int i = 0; i < 9; i++) {
            boolean[] flag = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int num = board[j][i] - '0';
                    if (flag[num]) return false;
                    flag[num] = true;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] flag = new boolean[10];
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        if (board[x][y] != '.') {
                            int num = board[x][y] - '0';
                            if (flag[num]) return false;
                            flag[num] = true;
                        }
                    }
                }
                
            }
        }
        return true;
    }
}