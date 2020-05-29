import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().lexicalOrder(13));
        System.out.println(new Solution().lexicalOrder(100));
    }
}

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int end = Math.min(n, 9);
        for (int i = 1; i <= end; i++) {
            talgo(n, i, list);
        }
        return list;
    }

    private static void talgo(int n, int x, List<Integer> list) {
        list.add(x);
        int end = Math.min(x*10+9, n);
        for (int i = x * 10; i <= end; i++) {
            talgo(n, i, list);
        }
    }
}