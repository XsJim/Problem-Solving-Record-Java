public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().tictactoe(new String[] {"O X"," XO","X O"}));
        System.out.println(new Solution().tictactoe(new String[] {"OOX","XXO","OXO"}));
        System.out.println(new Solution().tictactoe(new String[] {"OOX","XXO","OX "}));
        System.out.println(new Solution().tictactoe(new String[] {"O"}));
    }
}

class Solution {
    public String tictactoe(String[] board) {
        int n = board.length;
        char[][] boards = new char[n][];
        for (int i = 0; i < n; i++) {
            boards[i] = board[i].toCharArray();
        }

        int[][] countX = new int[3][];
        int[][] countY = new int[3][];
        for (int i = 0; i < 3; i++) {
            countX[i] = new int[n];
            countY[i] = new int[n];
        }

        int[] a = new int[3];
        int[] b = new int[3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = talgo(boards[i][j]);
                countX[x][i]++; countY[x][j]++;
                if (i == j) a[x]++;
                if (i + j == n - 1) b[x]++;
            }
        }

        if (a[1] == n || b[1] == n) return "X";
        if (a[2] == n || b[2] == n) return "O";

        int flag = 0;
        boolean flag_2 = true;
        want_break: for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 2; j++) {
                if (countX[j][i] == n || countY[j][i] == n) {
                    flag = j;
                    break want_break;
                }
            }
            if (flag_2) {
                if (countX[0][i] != 0 || countY[0][i] != 0) flag_2 = false;
            }
        }

        if (flag == 1) return "X";
        if (flag == 2) return "O";
        if (flag_2) return "Draw";
        else return "Pending";

    }

    private static int talgo(char x) {
        if (x == 'O') return 2;
        if (x == 'X') return 1;
        return 0;
    }
}