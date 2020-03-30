import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        List<String> list = new Solution().generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        talgo(n, n, "", list);
        return list;
    }

    private static void talgo(int left, int right, String ans, List<String> list) {
        if (left == 0 && right == 0) list.add(ans);
        else {
            if (left > 0) talgo(left-1, right, ans+'(', list);
            if (right > left) talgo(left, right-1, ans+')', list);
        }
    }
}