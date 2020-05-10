import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().processQueries(new int[] {3,1,2,1}, 5)));
        System.out.println(Arrays.toString(new Solution().processQueries(new int[] {4,1,2,2}, 4)));
        System.out.println(Arrays.toString(new Solution().processQueries(new int[] {7,5,5,8,3}, 8)));
    }
}

class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] ans = new int[queries.length];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = m; i > 0; i--) list.add(i);
        for (int i = 0; i < queries.length; i++) {
            int x = m - 1;
            for (int j : list) {
                if (j == queries[i]) {
                    ans[i] = x;
                    list.remove(m-1-x);
                    list.add(j);
                    break;
                }
                x--;
            }
        }
        return ans;
    }
}