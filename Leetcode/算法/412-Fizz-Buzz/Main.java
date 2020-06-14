import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().fizzBuzz(15));
    }
}

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        String fi = "Fizz", bu = "Buzz";
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) sb.append(fi);
            if (i % 5 == 0) sb.append(bu);
            if (sb.length() == 0) sb.append(String.valueOf(i));
            list.add(sb.toString());
        }
        return list;
    }
}