import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main (String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }
}

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        talgo(ans, new int[k], 0, 1, k, n);
        return ans;
    }

    private static void talgo(List<List<Integer>> ans, int[] l, int i, int m, int k, int n) {
        if (i == k) {
            List<Integer> list = new LinkedList<>();
            for (int x : l) list.add(x);
            ans.add(list);
            return;
        }
        while (m <= n) {
            l[i] = m++;
            talgo(ans, l, i+1, m, k, n);
        }
    }
}