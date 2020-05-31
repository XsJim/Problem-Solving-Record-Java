public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numRookCaptures(new char[][] {
            {'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},
            {'.','.','.','p','.','.','.','.'},{'p','p','.','R','.','p','B','.'},
            {'.','.','.','.','.','.','.','.'},{'.','.','.','B','.','.','.','.'},
            {'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}
        }));
    }
}

class Solution {
    public int numRookCaptures(char[][] board) {
        int sum = 0;
        W: for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    for (int z = i - 1; z >= 0; z--) {
                        if (board[z][j] == 'B') break;
                        else if (board[z][j] == 'p') {
                            sum++; break;
                        }
                    }
                    for (int z = i + 1; z < 8; z++) {
                        if (board[z][j] == 'B') break;
                        else if (board[z][j] == 'p') {
                            sum++; break;
                        }
                    }
                    for (int z = j - 1; z >= 0; z--) {
                        if (board[i][z] == 'B') break;
                        else if (board[i][z] == 'p') {
                            sum++; break;
                        }
                    }
                    for (int z = j + 1; z < 8; z++) {
                        if (board[i][z] == 'B') break;
                        else if (board[i][z] == 'p') {
                            sum++; break;
                        }
                    }
                    break W;
                }
            }
        }
        return sum;
    }
}