import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        talgo(0, 0, "", n, list);
        return list;
    }

    private static void talgo(int l, int r, String s, int n, List<String> list) {
        if (r == n) {
            list.add(s);
            return;
        }
        if (l == n) {
            talgo(l, r+1, s+")", n, list);
            return;
        }
        talgo(l+1, r, s+"(", n, list);
        if (l > r) talgo(l, r+1, s+")", n, list);
    }
}