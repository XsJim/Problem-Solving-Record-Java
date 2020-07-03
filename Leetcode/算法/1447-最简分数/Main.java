import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().simplifiedFractions(1));
        System.out.println(new Solution().simplifiedFractions(2));
        System.out.println(new Solution().simplifiedFractions(3));
        System.out.println(new Solution().simplifiedFractions(4));
    }
}

class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(j, i) == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(j);
                    sb.append('/');
                    sb.append(i);
                    list.add(sb.toString());
                }
            }
        }
        return list;
    }

    private static int gcd(int i, int j) {
        int x = i % j;
        while (x != 0) {
            i = j;
            j = x;
            x = i % j;
        }
        return j;
    }
}