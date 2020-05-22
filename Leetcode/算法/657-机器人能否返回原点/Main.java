public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().judgeCircle("UD"));
        System.out.println(new Solution().judgeCircle("LL"));
        System.out.println(new Solution().judgeCircle("RLRLLR"));
    }
}

class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') x--;
            else if (c == 'R') x++;
            else if (c == 'U') y--;
            else y++;
        }
        return (x == 0) && (y == 0);
    }
}