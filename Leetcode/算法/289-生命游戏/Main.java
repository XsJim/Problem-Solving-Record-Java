import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] board = new int[][] {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        new Solution().gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}

class Solution {
    public void gameOfLife(int[][] board) {
        int[] x = new int[] {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] y = new int[] {0, 0, -1, 1, -1, -1, 1, 1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int xx, yy;
                int l = 0;
                for (int z = 0; z < 8; z++) {
                    xx = i + x[z];
                    yy = j + y[z];
                    if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[i].length) {
                        if ((board[xx][yy] & 1) == 1) l++;
                    }
                }
                if (l == 3) board[i][j] |= 2;
                else if ((board[i][j] & 1) == 1 && l == 2) board[i][j] |= 2;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) board[i][j] >>= 1;
        }
    }
}