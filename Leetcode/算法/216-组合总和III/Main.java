import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 7));
        System.out.println(new Solution().combinationSum3(3, 9));
    }
}

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<>();
        talgo(k, n, 1, ans, new LinkedList<>());
        return ans;
    }

    private static void talgo(int k, int n, int i, List<List<Integer>> ans, LinkedList<Integer> list) {
        if (k == 0) {
            if (n == 0) {
                ans.add(new LinkedList<>(list));
            }
            return;
        }
        for (int x = i; x <= 9; x++) {
            list.add(x);
            talgo(k-1, n-x, x+1, ans, list);
            list.removeLast();
        }
    }
}